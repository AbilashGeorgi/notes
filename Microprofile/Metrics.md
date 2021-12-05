# Metrics

App running slowly etc. health may not be enough

Metrics:
* JVM
  * memory
  * thread count
* Application Server
  * connection pool
* custom
  * request count
  * response time

Time taken for a particular action is another metric

cloud native - metrics stored outside app

ex: prometheus is common tool for Kubernetes.


### Microprofile Metrics
Java API
 
provides known rest endpoints and some required metrics

metrics endpoint return JSON or OpenMetrics format
which is used by prometheus.

* identify trends and future issues

* /metrics endpoint

annotations available in eclipse microprofile github

@Timed(name = "abc",
  absolute = true,
  descrption = "")


@Counted(name = "Hello request count",
  absolute = true,
  monotonic = true,
  description = "")

* Collection of metrics using prometheus

> docker network create

> mvn install

> docker build -t demo:0.0.3 .

> docker run --rm --network metrics --name demo -p 9080:9080 demo:0.0.3


prometheus.yml
global:
  scrape_interval: 15s
  external_labels:
    monitor: 'demoapp-monitor'
scrape_configs:
  - job_name: 'prometheus'
    scrape_interval: 5s
    metrics_path: '/metrics/'
    static_configs:
      - targets: ['demo:9080']


> docker run --rm -d -p 9090:9090 --network metrics --name prometheus -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus:v2.4.0

GRAFANA comes with prometheus.
gives customizable dashboard