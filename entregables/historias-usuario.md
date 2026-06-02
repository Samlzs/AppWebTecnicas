# Historias de Usuario

## Historia de Usuario 1 - Registrar pacientes

Yo como gestor del centro de somnografías  
quiero registrar pacientes en el sistema  
para almacenar la información básica de las personas atendidas.

### Criterios de aceptación

- La información se ingresará mediante formularios.
- Los campos obligatorios no pueden estar vacíos.
- El documento debe ser único.
- El teléfono debe tener exactamente 10 números.
- El correo debe tener formato válido.
- Deben existir ayudas visuales para el usuario.
- La información debe almacenarse en MySQL.

## Historia de Usuario 1.1 - Listar y buscar pacientes

Yo como gestor del centro de somnografías  
quiero listar y buscar los pacientes registrados  
para consultar rápidamente la información almacenada.

### Criterios de aceptación

- El sistema debe mostrar los pacientes en una tabla.
- Debe permitir búsqueda por documento o nombre.
- La información debe estar ordenada.
- La interfaz debe usar Bootstrap.

## Historia de Usuario 1.2 - Editar pacientes

Yo como gestor del centro de somnografías  
quiero editar pacientes registrados  
para mantener actualizada la información.

### Criterios de aceptación

- El sistema debe permitir modificar los datos del paciente.
- Deben validarse los campos antes de guardar.
- Debe existir mensaje de confirmación.

## Historia de Usuario 1.3 - Eliminar pacientes

Yo como gestor del centro de somnografías  
quiero eliminar pacientes  
para mantener organizada la base de datos.

### Criterios de aceptación

- Debe solicitar confirmación antes de eliminar.
- Debe mostrar mensajes de éxito o error.
- Debe eliminarse el registro de la base de datos.
- Al eliminar un paciente, se eliminan sus somnografías asociadas.

## Historia de Usuario 1.4 - Ver detalle del paciente

Yo como gestor del centro de somnografías  
quiero consultar el detalle de un paciente  
para revisar su información completa y sus somnografías asociadas.

### Criterios de aceptación

- El sistema debe mostrar los datos completos del paciente.
- Debe mostrar las somnografías asociadas al paciente.
- Debe permitir volver al listado de pacientes.
- Debe permitir acceder a la edición del paciente.

## Historia de Usuario 2 - Registrar somnografía

Yo como especialista del centro de somnografías  
quiero registrar una somnografía asociada a un paciente  
para almacenar la información del estudio realizado.

### Criterios de aceptación

- El sistema debe permitir seleccionar un paciente registrado.
- Debe permitir ingresar fecha del estudio, tipo, estado, observaciones y resultado.
- La fecha debe seleccionarse con calendario JS.
- Los campos obligatorios no pueden estar vacíos.
- La información debe almacenarse en la base de datos.

## Historia de Usuario 2.1 - Listar somnografías

Yo como especialista del centro de somnografías  
quiero listar las somnografías registradas  
para consultar los estudios realizados.

### Criterios de aceptación

- Debe mostrarse una tabla con paciente, fecha, tipo, resultado y estado.
- La información debe mostrarse ordenada por fecha.
- El estado debe diferenciarse visualmente con colores.
- La interfaz debe usar Bootstrap.

## Historia de Usuario 2.2 - Editar somnografías

Yo como especialista del centro de somnografías  
quiero editar los registros de somnografías  
para corregir información del estudio.

### Criterios de aceptación

- El sistema debe permitir modificar registros.
- Deben aplicarse validaciones básicas.
- Debe existir mensaje de confirmación.

## Historia de Usuario 2.3 - Eliminar somnografías

Yo como especialista del centro de somnografías  
quiero eliminar registros de somnografías  
para mantener actualizada la información.

### Criterios de aceptación

- Debe solicitar confirmación antes de eliminar.
- Debe mostrar mensajes de éxito o error.
- Debe eliminarse el registro de la base de datos.

## Historia de Usuario 2.4 - Ver detalle de somnografía

Yo como especialista del centro de somnografías  
quiero consultar el detalle de una somnografía  
para revisar toda la información del estudio y del paciente asociado.

### Criterios de aceptación

- El sistema debe mostrar paciente, documento, fecha, tipo, estado, resultado y observaciones.
- Debe permitir volver al listado de somnografías.
- Debe permitir editar la somnografía.

## Historia de Usuario 3 - Programar estudio en agenda

Yo como gestor del centro de somnografías  
quiero asignar fecha y hora programada a una somnografía  
para organizar los estudios pendientes.

### Criterios de aceptación

- El sistema debe permitir registrar fecha programada.
- El sistema debe permitir registrar hora programada.
- La fecha programada debe seleccionarse con calendario JS.
- La somnografía programada debe aparecer en la agenda.

## Historia de Usuario 3.1 - Consultar agenda de estudios

Yo como gestor del centro de somnografías  
quiero consultar una agenda de estudios programados  
para visualizar los estudios pendientes por realizar o revisar.

### Criterios de aceptación

- El sistema debe mostrar las somnografías con fecha programada.
- No deben mostrarse somnografías finalizadas o anuladas.
- Los estudios deben ordenarse por fecha y hora programada.
- Debe permitir acceder al detalle o edición de cada somnografía.

## Historia de Usuario 4 - Consultar inicio del sistema

Yo como usuario del sistema  
quiero ver una página de inicio con información general  
para comprender el propósito de la aplicación y acceder a sus módulos.

### Criterios de aceptación

- El inicio debe explicar qué es una somnografía.
- Debe mostrar accesos a pacientes, somnografías y agenda.
- Debe mostrar estadísticas básicas del sistema.
- La página debe usar Bootstrap y estilos personalizados.
