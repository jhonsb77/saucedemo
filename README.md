# Proyecto automatizacion portal Swag Labs

<p align="center">
  <a href="https://serenity-bdd.github.io/theserenitybook/latest/index.html"> 
  <img src="https://serenity-bdd.info/wp-content/uploads/elementor/thumbs/serenity-bdd-pac9onzlqv9ebi90cpg4zsqnp28x4trd1adftgkwbq.png" title="Serenity"> 
  </a>
  <a href="https://cucumber.io/"> 
  <img src="https://blog.softtek.com/hubfs/blogs/innovationlabs/cucumberlogo.png" title="Cucumber BDD"> 
  </a>
  <a href="https://www.selenium.dev/"> 
  <img src="https://selenium-python.readthedocs.io/_static/logo.png" title="Selenium" > 
  </a>
  <a href="https://gradle.org/"> 
  <img src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228" title="Gradle" > 
  </a> 
</p>

Pre-requisitos
- Mozilla firefox
- JDK version 1.8.0
- Gradle 7.4
- Entorno de desarrollo IntelliJ IDEA
- Git

nota: debido a que el driver de chrome a la fecha solo esta disponible para versiones anteriores a la 114, la ejecucion solo funciona para el navegador mozilla firefox
![img_1.png](img_1.png)
repositorio de los drivers para chrome https://chromedriver.chromium.org/downloads

Estructura del proyecto
- features: en esta carpeta se encuentra redactado los casos de prueba en lenguaje gherkin
- stepsdefinitons: en esta carpeta se encuentra el paso a paso de los features que se utiliza para asociarlos a los archivos feature
- page: se encuentra toda la logica de programacion utilizada por los casos de prueba
- runner: clase la cual se utiliza para ejecutar los casos de prueba
- utils: configuracion del driver correspondiente al navegador donde se ejecutaran las pruebas

Instrucciones de ejecucion
1. Clonar el proyecto del repositorio https://github.com/jhonsb77/saucedemo.git mediante el comando git clone en la carpeta deseada de su equipo
2. En el etorno de desarrrollo, seleccionar la opcion "File" y posteriormente la opcion "Open". Alli seleccionara el proyecto guardado en la ruta del paso anterior
3. Esperar a que el proyecto se configure y descargue las dependecias, si esto no se realiza, en el archivo "build.gradle" seleccionar la opcion "reload all gradle projects"
   ![img_2.png](img_2.png)
4. Seleccionar el archivo runner, dar click derecho y seleccionar la opcion "Run"
5. Al finalizar la ejecucion los reportes de la misma se podran visualizar en el archivo index.html ubicado en la ruta: saucedemo\target\site\serenity


CI

URL jenkins: https://70e4-181-237-226-23.ngrok-free.app/
- user: admin
- pass: 1234
- 
El proyecto cuenta con 2 jobs:
1. saucedemo: en este job se encuentra el proyecto para la ejecucion de los casos de prueba.
Para ejecutarlo se selecciona la opcion build with parametres , seleccionar el escenario a ejecutar
y dar click en ejecucion, al finalizar el reporte se podra visualizar en la pestaña serenity report.
2. saucedemo-sonar: en este job se encuentra el analisis del codigo utilizando sonar.
Para ejecutarlo, selecciona la opcion construir ahora. Al finalizar la ejecucion el reporte se podra
visualizar en la siguiente url:

URL sonarqube: https://4282-181-237-226-23.ngrok-free.app/
- user: admin
- pass: 1234

