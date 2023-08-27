
#!/bin/bash
variable=${1}

mensajes(){
echo "Hackeando ando..."
echo "Accediendo a los sistemas....."
echo "EL numero ingresado es:$variable" 
}
fecha(){
echo "Obteniendo la fecha"
date
}

echo" "
#Documentacion
#Leer el archivo de los usuarios
echo " "
cat /etc/passwd
mensajes 
fecha
