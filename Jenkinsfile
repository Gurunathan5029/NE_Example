        /* This pipeline creates a docker compose and then executes all the scripts. Note the Jenkins has to be in Linux environment */
node {
    def app

    stage('Clone repository') {
        /* Clone repository */
        checkout scm
    }

    stage('Docker Setup') {
        parallel(
          "Start Compose": {
    		/* Start docker-compose with five instances of Chrome */
    	    cmd_exec('docker-compose up -d --scale chrome=5')
          },
          "Build Image": {
            /* This builds an image with all Serenity selenium scripts in it */
    		def dockerfile = 'bddSerenity.Dockerfile'
            app = docker.build("serenity-with-src","-f ${dockerfile} ./")
          }
        )
    }    

    stage('Execute') {
		/* Execute the serenity script. On faliure proceed to next step */
         sh "docker run --rm -e mvn clean verify -Dwebdriver.remote.url -Dwebdriver.remote.driver="chrome""
        }
    

    stage('Docker Teardown') {
        parallel(
          "Stop Compose": {
    		/* Tear down docker compose */
            cmd_exec('docker-compose down --rmi local')
          },
          "Remove Image": {
            /* Delete the image which got created earlier */
            cmd_exec('docker rmi serenity-with-src -f')
          }
        )
    }    

    stage('Create Report') {
        /* Generate Serenity Report */
        allure includeProperties: false, jdk: '', results: [[path: 'report']]
    }

}

def cmd_exec(command) {
    if (isUnix()) {
        return sh(returnStdout: true, script: "${command}").trim()
    }
    else {
        return bat(returnStdout: true, script: "${command}").trim()
    }
}