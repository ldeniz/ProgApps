#!/bin/bash
cd web/
ant clean;ant
sleep 1
cd ..
cd gui 
ant clean;ant
sleep1
cd ..
cd mobile
ant clean;ant
cd ..
mkdir -p /tmp/clientes /tmp/productos/ /tmp/restaurantes
cd imagenes/
cp * /tmp/
cd ..
