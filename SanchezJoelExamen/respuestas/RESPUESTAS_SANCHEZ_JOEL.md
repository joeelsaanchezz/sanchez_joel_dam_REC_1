PREGUNTA 1: Explica cómo funciona la relación 1:N entre CentroForense y MuestraForense tanto en SQL como en Java.
En SQL lo que hacemos es una foreign key para poder almacenar el ID unico del CentroForense dentro de MuestraForense, de esta forma se conectan las dos tablas y podemos hacer joints para las buquedas entre tablas. Por otro lado en el java lo que hemos hecho ha sido crear un atributo CentroForense que es un objeto CentroForense para poder almacenar el objeto entero dentro del propio objeto de MuestraObjeto.


PREGUNTA 2: Explica por qué en Java utilizamos: private CentroForense centro y no: private int centroId;
Esto tiene relación con la pregunta anterior, ya que como he expolicado anteriormente, lo hacemos de este modo porque así podemos almacenar el objeto entero de CentroForense dentro del objeto de MuestraForense. Y esto nos sirve para poder acceder a todos los datos, de la otra manera solo tendriamos el ID.

PREGUNTA 3: Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.
Evitamos la injección de datos. Si lo concatenasemos, los usuarios podrían eliminarnos la base de datos. De esta manera nos aseguramos que no pueden, lo que lo hace mucho más seguro.
