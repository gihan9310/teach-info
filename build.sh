#!/bin/bash

set -e  # Exit on any error

IMAGE_TAG="${1:-latest}"

echo "🔐 Logging in to Docker Hub..."

docker login --username rathnayakaegb.soft@gmail.com --password #### BAND PRACTICES

docker build -t gihansoft/gihan:$IMAGE_TAG .

echo "🚀 Pushing image to Docker Hub..."

docker push gihansoft/gihan:$IMAGE_TAG

echo "🚀 Pushing image to Docker Hub..."

echo "🎉 Done: $FULL_IMAGE_NAME"