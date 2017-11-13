burgershop - hibernate
======================

This project contains a stripped hibernate version of burgershop without any MoSKito instrumentation.
Hibernate means created orders are stored to database via Hibernate.
This is used as
* example of burgershop app without MoSKito. 
* example for the usage of the javaagent sql monitoring.

Setup datasource in servlet-context.xml, create 'Orders' table according to resources/create_orders_table.sql
Build with maven and run in the servlet container of your choice.

 
