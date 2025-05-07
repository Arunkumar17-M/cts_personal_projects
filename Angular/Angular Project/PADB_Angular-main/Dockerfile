FROM registry.access.redhat.com/ubi9/nginx-122:1-73

# Add application sources
ADD nginx.conf "${NGINX_CONF_PATH}"
ADD mime.types ./
ADD dist ./public/

# Run script uses standard ways to run the application
CMD nginx -g "daemon off;"
