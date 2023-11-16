# Stage 1: Build the Angular app
FROM node:14 as build

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build --prod

# Stage 2: Serve the Angular app using Nginx
FROM nginx:alpine

COPY --from=build /usr/src/app/dist/your-app-name /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
