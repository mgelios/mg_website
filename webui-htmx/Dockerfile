FROM alpine:latest as yarn-prepare-stage

FROM yarn-prepare-stage as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn install
COPY . .
RUN yarn build

FROM nginx:stable-alpine as ui-production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
# COPY ./nginx.conf /etc/nginx/nginx.conf
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
