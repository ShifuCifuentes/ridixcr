--PostgreSQL Maestro

--SQL Editor queries 


--Query &1

select cast(upper(EM.ap_paterno||' '||EM.ap_materno||','||EM.nombres) as varchar) as persona,EM.direccion,EM.telefono,CN.nombre_cuenta
FROM dbo.empleado EM
inner join dbo.cuenta CN
on EM.codigo_empleado=CN.codigo_empleado;
--Query &2

select cast(upper(EM.ap_paterno||' '||EM.ap_materno||','||EM.nombres) as varchar) as persona,CN.nombre_cuenta
FROM dbo.empleado EM
inner join dbo.cuenta CN
on EM.codigo_empleado=CN.codigo_empleado
where CN.estado=true;
--Query &3

select cast(upper(EM.ap_paterno||' '||EM.ap_materno||','||EM.nombres) as varchar) as personal,CN.nombre_cuenta,count(VN.codigo_cuenta) as cantidad_ventas
from  dbo.venta VN
inner join dbo.cuenta CN
on VN.codigo_cuenta=CN.codigo_cuenta
inner join dbo.empleado EM
on CN.codigo_empleado=EM.codigo_empleado
group by VN.codigo_cuenta,EM.ap_paterno,EM.ap_materno,EM.nombres,CN.nombre_cuenta;
--Query &5

select  dbo.importe_total(),PR.denominacion,sum(DV.cantidad_venta) as cantidad,sum(DV.cantidad_venta*(PR.precio_compra+(PR.precio_compra*(PR.porcentaje_utilidad)/100)))as importe_total,VN.fecha_venta
from  dbo.venta VN
inner join dbo.detalle_venta DV
on VN.codigo_venta=DV.codigo_venta
inner join dbo.producto PR
on DV.codigo_producto=PR.codigo_producto
where VN.fecha_venta = current_date
group by PR.denominacion,DV.codigo_producto,VN.fecha_venta;

--Query &4

select  sum(DV.cantidad_venta*(PR.precio_compra+(PR.precio_compra*(PR.porcentaje_utilidad)/100))) as monto_total
from  dbo.venta VN
inner join dbo.detalle_venta DV
on VN.codigo_venta=DV.codigo_venta
inner join dbo.producto PR
on DV.codigo_producto=PR.codigo_producto
where VN.fecha_venta = current_date 
group by DV.cantidad_venta;
--Query &6

CREATE OR REPLACE FUNCTION dbo.importe_total()
RETURNS double precision AS
$$
begin
return (
 select  sum(DV.cantidad_venta*(PR.precio_compra+(PR.precio_compra*(PR.porcentaje_utilidad)/100))) as monto_total
from  dbo.venta VN
inner join dbo.detalle_venta DV
on VN.codigo_venta=DV.codigo_venta
inner join dbo.producto PR
on DV.codigo_producto=PR.codigo_producto
where VN.fecha_venta = current_date 
group by DV.cantidad_venta);
end
$$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION dbo.buscar_fabricante
(
  p_codigo_fabricante  integer
)
RETURNS TABLE 
(
  o_codigo_fabricante  integer,
  o_nombre_fabricante  varchar,
  p_direccion          varchar,
  o_telefono           varchar,
  o_fecha_registro     date
)
AS
$$
begin
  return query(
   select  codigo_fabricante,nombre_fabricante,direccion,telefono ,fecha_registro 
   FROM dbo.fabricante
   where codigo_fabricante=p_codigo_fabricante
  );
  
end
$$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION dbo.registrar_compra
(
  p_codigo_cuenta  integer
)
RETURNS TABLE 
(
  o_codigo_compra integer
)
AS
$$
begin
 return query
  insert into dbo.compra(codigo_cuenta)
  values(p_codigo_cuenta)
  returning codigo_compra;
end
$$
LANGUAGE 'plpgsql';

select PR.denominacion,PR.presentacion,AL.stock_actual,PR.fecha_vencimineto
from dbo.producto PR
inner join dbo.almacen AL
on PR.codigo_producto=AL.codigo_producto
where PR.fecha_vencimineto is not null and (PR.fecha_vencimineto-current_date)<=60