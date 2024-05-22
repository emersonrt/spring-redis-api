# Use the official PostgreSQL image from the Docker Hub
FROM postgres:12

# Set environment variables
ENV POSTGRES_USER myuser
ENV POSTGRES_PASSWORD mypassword
ENV POSTGRES_DB spring_redis_db

# Expose the PostgreSQL port
EXPOSE 5432

# Copy the init.sql script to the docker-entrypoint-initdb.d directory
COPY init.sql /docker-entrypoint-initdb.d/