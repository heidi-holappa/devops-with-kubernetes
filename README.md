# DevOps with Kubernetes



## Cheat sheet


Build image locally


```
docker build -t <image-name> .
```

Tag the image

```
docker tag <image-name>:<tag> rainbowdazed/<image-name>:<tag>
```

Push the image

```
docker push rainbowdazed/<image-name>:<tag>
```





Delete cluster: 
```
k3d cluster delete
```

Create cluster with loadbalancer and open ports

```
k3d cluster create --port 8082:30080@agent:0 -p 8081:80@loadbalancer --agents 2
```

And together

```
k3d cluster delete && k3d cluster create --port 8082:30080@agent:0 -p 8081:80@loadbalancer --agents 2 && kubectl apply -f manifests/ 
```

```

```