# KUBERNETES

managing containers
* scaling
* discovery
* monitoring

Orchestration tools help in this
ex: Docker Swarm, Kubernetes

## Kubernetes
means Helmsman in ancient greek

steer application arch

also known as K8s or Kube

* containers are deployed into pods
* pod is a collection of one or more containers sharing the same lifecycle
* containers in a single pod are deployed, updated and taken down together.
* often one container per pod
* scaling - start multiple identical pods
* commonly managed by a Deployment
* Pods and deployments created using a yaml file
* if a pod goes down kube will bring one back up to replace it.

Rather than calling a pod directly, other applications will call via a Service.

Kubernetes Service will handle balancing the load across the pods.

Service is accessible via an internal name called the DNS name.

Services can also be exposed outside your kube cluster.

Service knows which pod to direct to using a label and selector pair.

* deployment.yaml has label for pods
* service.yaml we define selector. any pod matching selector is eligible for traffic
* pods can say they are not ready.



> kubectl get nodes
deploy: 
> kubectl apply -f deployment.yaml

show running pods
> kubectl get pods

scale to 3
> kubectl scale --replicas 3 deployment/microprofile-deploy

> kubectl apply -f service.yaml

> kubectl get service


