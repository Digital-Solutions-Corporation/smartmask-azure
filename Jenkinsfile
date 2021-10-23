node {
  def resourceGroupName = 'rg-smartmask'
  def resourceGroupLocation = 'brazilsouth'
  def appServicePlanName = 'as-smartmask'
  def appServicePlanTier = 'FREE'
  def webAppName = 'webapp-smartmask'
  def webAppRuntime = '"java|11|Java SE|8"'
  def packagePath = 'target/smartmask-0.0.1-SNAPSHOT.jar'

  stage("Fetch") {
    echo "Getting source code from https://github.com/Digital-Solutions-Corporation/smartmask-azure"
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/backend-mobile']],
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
  stage('Pre-deploy') {
    echo 'Configuring webapp...'

    echo 'Creating resource group...'
    sh "az group create --name $resourceGroupName --location $resourceGroupLocation"

    echo 'Creating app service plan...' 
    sh "az appservice plan create --name $appServicePlanName --resource-group $resourceGroupName --sku $appServicePlanTier"

    echo 'Creating webapp...'
    sh "az webapp create --name $webAppName --plan $appServicePlanName --resource-group $resourceGroupName --runtime $webAppRuntime"
  }
	stage('Deploy') {
		echo 'Deploying to azure webapp...'
    withCredentials([usernamePassword(credentialsId: 'AzureServicePrincipal', passwordVariable: 'AZURE_CLIENT_SECRET', usernameVariable: 'AZURE_CLIENT_ID')]) {
      sh 'az login -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET'
			sh "az webapp deploy --resource-group $resourceGroupName --name $webAppName --src-path $packagePath --type jar"
    }
  }
}