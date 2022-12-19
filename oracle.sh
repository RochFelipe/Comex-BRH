docker volume create oracle-volume 
docker run -v oracle-volume:/opt/oracle/oradata -d --name oracle -p 1521:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe;
