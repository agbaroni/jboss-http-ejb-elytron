```
nmcli connection add \
  connection.autoconnect TRUE \
  connection.id DBMS \
  connection.interface-name dbms \
  connection.type dummy \
  ipv4.addresses 172.31.252.1/24 \
  ipv4.method manual

nmcli connection add \
  connection.autoconnect TRUE \
  connection.id JBF1 \
  connection.interface-name jbf1 \
  connection.type dummy \
  ipv4.addresses 172.31.253.1/24 \
  ipv4.method manual

nmcli connection add \
  connection.autoconnect TRUE \
  connection.id JBF2 \
  connection.interface-name jbf2 \
  connection.type dummy \
  ipv4.addresses 172.31.253.2/24 \
  ipv4.method manual

nmcli connection add \
  connection.autoconnect TRUE \
  connection.id JBB1 \
  connection.interface-name jbb1 \
  connection.type dummy \
  ipv4.addresses 172.31.254.1/24 \
  ipv4.method manual

nmcli connection add \
  connection.autoconnect TRUE \
  connection.id JBB2 \
  connection.interface-name jbb2 \
  connection.type dummy \
  ipv4.addresses 172.31.254.2/24 \
  ipv4.method manual
```

```
podman run --name jhee --rm -dit -p 5433:5432 -e POSTGRES_USER=test -e POSTGRES_PASSWORD=test -e POSTGRES_DB=test postgres
```

```
mkdir -p servers/frontends/frontend1

cp -r jboss-eap-7.4/standalone/configuration servers/frontends/frontend1

rm -f servers/frontends/frontend1/configuration/standalone{,-full,-ha,-load-balancer}.xml

mv servers/frontends/frontend1/configuration/standalone{-full-ha,}.xml

cp custom-management-users.properties servers/frontends/frontend1/configuration/
cp custom-management-groups.properties servers/frontends/frontend1/configuration/

cp custom-application-users.properties servers/frontends/frontend1/configuration/
cp custom-application-groups.properties servers/frontends/frontend1/configuration/

cp custom-remoting-users.properties servers/frontends/frontend1/configuration/
cp custom-remoting-groups.properties servers/frontends/frontend1/configuration/

./jboss-eap-7.4/bin/jboss-cli.sh -Djboss.server.base.dir=$PWD/servers/frontends/frontend1 --file=frontend1.cli

./jboss-eap-7.4/bin/standalone.sh -Djboss.server.base.dir=$PWD/servers/frontends/frontend1
```

```
mkdir -p severs/backends/backend1

cp -r jboss-eap-7.4/standalone/configuration servers/backends/backend1

rm -f servers/backends/backend1/configuration/standalone{,-full,-ha,-load-balancer}.xml

mv servers/backends/backend1/configuration/standalone{-full-ha,}.xml

cp custom-management-users.properties servers/backends/backend1/configuration/
cp custom-management-groups.properties servers/backends/backend1/configuration/

cp custom-application-users.properties servers/backends/backend1/configuration/
cp custom-application-groups.properties servers/backends/backend1/configuration/

cp custom-remoting-users.properties servers/backends/backend1/configuration/
cp custom-remoting-groups.properties servers/backends/backend1/configuration/

./jboss-eap-7.4/bin/jboss-cli.sh -Djboss.server.base.dir=$PWD/servers/backends/backend1 --file=backend1.cli

./jboss-eap-7.4/bin/standalone.sh -Djboss.server.base.dir=$PWD/servers/backends/backend1
```
