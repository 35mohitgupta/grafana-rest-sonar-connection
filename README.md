# grafana-rest-sonar-connection
This project provides sonarqube measures to the grafna dashboard. /annotatation, /tag-key and /tag-value not completed rest is working

For this,
  start sonarqube ar localhost:9000
  start grafana;
    -docker 
      sudo docker run -d -p 3000:3000 -e "GF_INSTALL_PLUGINS=grafana-clock-panel,grafana-simple-json-datasource" grafana/grafana
