call "C:\Program Files\MySQL\MySQL Server 5.6\bin\mysql.exe" -P3306 -hlocalhost -uroot -pjuanez2191 zabavypos -e"SELECT 'POS1' as 'POS', productos.NomProd as 'Producto', CONCAT(usuarios.NomUser, ' ', usuarios.ApelUser) as 'Usuario', historial.Valor, historial.Pago, historial.Fecha FROM historial INNER JOIN usuarios ON historial.CedUser=usuarios.CedUser INNER JOIN productos ON historial.IdProd=productos.Producto ORDER BY FECHA DESC LIMIT 1000 INTO OUTFILE 'C:\\ZabavyPOS\\datos\\HISTORIAL.csv' FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n';"
start C:\\ZabavyPOS\\datos\\HISTORIAL.csv
start C:\\ZabavyPOS\\datos\\Reporte.xlsx
exit
exit
