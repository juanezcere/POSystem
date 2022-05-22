call "C:\Program Files\MySQL\MySQL Server 5.6\bin\mysql.exe" -P3306 -hlocalhost -uroot -pjuanez2191 zabavypos -e"SELECT * FROM zabavypos.facturas ORDER BY Fecha DESC INTO OUTFILE 'C:\\ZabavyPOS\\datos\\FACTURAS.csv' FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n';"
start C:\\ZabavyPOS\\datos\\FACTURAS.csv
start C:\\ZabavyPOS\\datos\\Reporte.xlsx
exit
exit