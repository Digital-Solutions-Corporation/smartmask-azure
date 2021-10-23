node {
  stage("Fetch") {
    echo "Getting source code from https://github.com/Digital-Solutions-Corporation/smartmask-azure"
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      submoduleCfg: [],
      userRemoteConfigs: [[url: 'https://github.com/Digital-Solutions-Corporation/smartmask-azure.git']]
    ])        
  }
  stage('Build') {
    echo 'Building webapp...'
    sh '/opt/maven/bin/mvn clean package'
  }
	stage('Deploy') {
		echo 'Deploying to azure webapp...'
    def resourceGroup = 'rg-smartmask'
    def webAppName = 'webapp-smartmask'
		def packagePath = 'target/smartmask-0.0.1-SNAPSHOT.jar'
    withCredentials([usernamePassword(credentialsId: 'AzureServicePrincipal', passwordVariable: 'AZURE_CLIENT_SECRET', usernameVariable: 'AZURE_CLIENT_ID')]) {
      sh 'az login -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET'
			sh "az webapp deploy --resource-group $resourceGroup --name $webAppName --src-path $packagePath --type jar"
    }
  }
}