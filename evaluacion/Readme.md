##Evaluacion final java

#Menu Juego


Boton "Desplegar Carro"	:Debe generar los 18 carros llamando a crearCarros(), preguntar los datos para cada carro y llenar arreglo de objeto carro, mostrar el 					tablero (ocultando ubicacion), confirmar el despliegue.

Boton "Iniciar Patida" 		:Oculta botones desplegar y jugar, Muestra contenido de listado de carros agrupados por tipo, puede preguntar nombre de usuario y pone 					contadores a cero;

Botón "Disparar Huevo"		:pregunta cordenadas de tiro/azar, luego con las cordenadas verifica si hay impacto, llama a lanzarHuevo(), pregunta si desea otro tiro;

Botón "Mostrar Tablero" 	:Actualiza tablero llamando a mostrarMatriz();

Boton "Finalizar Partida":Pide confirmacion, muestra ubicacion de carros en tablero, impactos y estadisticas (cantidad de tiros, puntaje obtenido, etc), luego reinicia contadores (podria guradar datos en txt) y muestra el menu inicial

Botón "Salir":Muestra estadisticas, pide confirmacion y luego cierra todo.

#Metodos (funciones):

crearCarro():Genera un objeto carro (de model) y la suma a la lista [Ejecutor.java-28] // Se chequea la disponibildad del la casilla, de estar disponible chequea las celdas contiguas para la creacion del objeto; de estar todos disponibles, los ubica en la matriz. Ubica tres elementos de clase Kromi, Cinco de tipo Caguano y Diez de tipo Trupalla. En paralelo crea la lista correspondiente a cada elemento con su clase y coordenadas.

lanzarHuevo():Crea una instancia de huevo, con la coordenada ya sea indicada por el usuario como aleatoriamente, registrando puntaje y la suma a la lista, modificando el atributo estado de cada objeto, con el foco en conocer el estado general del elemento en caso de ser alcanzado.

mostrarMatriz():Muestra el estado del campo de juego, con los objetos y los disparos, al momento de la consulta

calcularPuntaje():Suma los puntajes y los devuelve. Calcula la tabla segun los puntajes obtenidos y finaliza la partida



#LISTA DE CARROS

#Cantidad  Puntos al impactar

Nombre		Cantidad 	Puntos 	Total

K Kromi     3			+3  		 +10

C Caguano   5			+2  		 +7

T Trupalla  10			+1

H Huevo

lista total carro =18 instancias

lista disparos huevo = ilimitado




