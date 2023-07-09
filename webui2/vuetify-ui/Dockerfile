FROM alpine:latest as yarn-prepare-stage
RUN apk add --update nodejs npm yarn

FROM yarn-prepare-stage as build-stage
WORKDIR /app
COPY package*.json ./
RUN yarn install
COPY . .
RUN yarn build

# production stage
FROM nginx:stable-alpine as ui-production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
