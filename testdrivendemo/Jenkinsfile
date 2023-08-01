pipeline { 

    agent any 

    stages { 

        stage('git repo & clean') { 

            steps { 

                script { 

                    // Check if directory exists before removing it 

                    if (fileExists('spring_jenkins/testdrivendemo')) { 

                        bat "rmdir /s /q spring_jenkins/testdrivendemo" 

                    } 

                     

                    bat "git clone https://github.com/SOORIASUKUMARAN/spring_jenkins.git" 

                    bat "mvn clean -f spring_jenkins/spring_jenkins/testdrivendemo/pom.xml" 

                } 

            } 

        } 

        stage('install') { 

            steps { 

                bat "mvn install -f spring_jenkins/testdrivendemo/pom.xml" 

            } 

        } 

        stage('test') { 

            steps { 

                bat "mvn test -f spring_jenkins/testdrivendemo/pom.xml" 

            } 

        } 

        stage('package') { 

            steps { 

                bat "mvn package -f spring_jenkins/testdrivendemo/pom.xml" 

            } 

        } 

    } 

} 

 

def fileExists(String path) { 

    try { 

        fileExists = new File(path).isDirectory() 

    } catch (Exception e) { 

        fileExists = false 

    } 

    return fileExists 

} 
