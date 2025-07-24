# Etapa 1: build de Angular
FROM node:20-alpine as builder

WORKDIR /app
COPY . .
RUN npm install && npm run build --prod

# Etapa 2: servidor Nginx
FROM nginx:alpine

# Copia desde la carpeta "browser"
COPY --from=builder /app/dist/front-seguros-vehiculares/browser /usr/share/nginx/html

# Configura Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf
