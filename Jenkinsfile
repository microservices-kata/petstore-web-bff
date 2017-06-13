def srvName = 'web-bff'
def gitRepo = 'https://github.com/microservices-kata/petstore-web-bff.git'
def devUser = 'scaleworks'
def devHost = '10.202.129.46'
def registryUrl = '10.202.129.203:5000'
node('microservice') {
    stage('代码更新') {
        checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']], 
                      userRemoteConfigs: [[url: gitRepo]]]
    }
    stage('构建代码') {
        sh "mvn clean package"
    }
    stage('更新契约') {
        sh "export PACT_BROKER_URL=\"http://${devHost}:2000\"; mvn pact:publish"
    }
    stage('创建镜像') {
        sh "mv -f target/*.jar deployment/${srvName}.jar"
        sh "docker build -t ${registryUrl}/${srvName}:$BUILD_NUMBER deployment"
        sh "docker push ${registryUrl}/${srvName}:$BUILD_NUMBER"
        sh "docker rmi ${registryUrl}/${srvName}:$BUILD_NUMBER"
    }
}
node('master') {
    stage('部署Dev环境') {
        sh "ssh ${devUser}@${devHost} docker rm -f ${srvName} | true"
        sh "ssh ${devUser}@${devHost} docker run -d --name ${srvName} --net=host \
            ${registryUrl}/${srvName}:$BUILD_NUMBER"
        sh "ssh ${devUser}@${devHost} docker image prune --force --all \
            --filter until=`date -d '5 day ago' '+%F'`"
    }
}
