burgershop - sql
================

This project contains a stripped sql version of burgershop without any MoSKito instrumentation.
Sql means created orders are stored to database.
This is used as
* example of burgershop app without MoSKito. 
* example for the usage of the javaagent sql monitoring.

Setup datasource in servlet-context.xml, create 'Orders' table according to resources/create_orders_table.sql
Build with maven and run in the servlet container of your choice.

 
