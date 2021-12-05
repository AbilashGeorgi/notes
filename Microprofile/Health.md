# Health Checks

lookup time to requests or metric.

usually endpoiint /health GET should return 200

complex app 2 endpoints.

cloud environment - should plan for errors and downtime

1st endpoint - is app up? (Liveness) - can be determined by platform itself
2nd - ready to recieve requests.(readiness)
only known by application

* Use automation to monitor health

Eclipse Microprofile Health
* protocol
* Java API

## Integrate health checks into Kubernetes
* kubernetes is self healing - when one goes down replace with healthy one.

* liveness check

* A liveness probe is provided which is an endpoint which if k8s gets 100 response healthy

* We can provide port of endpoint, frequency of check etc.

* Readiness probes
  * when app is ready to recieve traffic
  * defined similar to liveness probe.

> spec:
      containers:
      - name: demo
        image: demo:0.0.1
        ports:
        - containerPort: 9080
          name: http
        - containerPort: 9443
          name: https
        readinessProbe:
            httpGet:
              path: /health
              port: 9080
              httpHeaders:
                - name: Accept
                  value: '*/*'

