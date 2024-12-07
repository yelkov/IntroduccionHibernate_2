# EJERCICIO 1
Crea un nuevo proyecto Hibernate con los siguientes requisitos:

1. Crea una clase Studentcon id, name, DNI y phone. El identificador de dicha clase será almacenado en el DBMS como una secuencia. Sobreescribe los métodos toString y equals de dicha clase. El nombre de la tabla será students con columnas idstudent, name, identification y phone.
2. Añade una clase Course con atributos id, description, beginDate y endDate. El identificador de dicha clase será almacenado en el DBMS como autoincremental. ¿Sería lo mismo que si pusiésemos estrategia auto? Sobreescribe los métodos toString y equals de dicha clase. Limita el tamaño de la descripición a 100 carácteres. En el caso de que no se especifique la fecha de inicio está tomará por defecto la fecha actual. El atributo endDate puede admitir nulos. El nombre de la tabla será courses con columnas idcourse, description, begindate, enddate.
3. Añade una clase Card con atributos id, code y type. El identificador de dicha clase será autogenerado con una estrategia de secuencia. ¿En qué consiste esta estrategia? El atributo type podrá tomar los valores eso, bac o fp y no se almacenará en la base de datos. El nombre de la tabla será cards con columnas idcard, code.
4. Asocia con una relación la clase Student y la clase Course considerando que un estudiante puede hacer múltiples courses y un course puede ser realizado por múltiples courses. ¿Qué tipos de comportamiento podemos especificar en la relación? Demuestra su uso.
5. Relaciona la clase Student con Card de forma que un estudiante tenga una única tarjeta y una tarjeta esté asociada a un único estudiante.
6. Crea 2 students, 2 cards y 1 course. Asócialos y hazlos persistentes en la BD. ¿Qué pasa al borrar un estudiante? ¿Se borra su card asociada?


Extras:
1. Crea una herencia respecto a la clase Student de forma que los students puedan ser DevOps o Developers. Los developers tendrán una lista de lenguajes de programación que dominan mientras que los DevOps tendrán una lista de herramientas que dominan.
2. Busca información sobre el mapeo objeto-relacional con ficheros XML en lugar de annotations. Haz una demostración para este proyecto.  