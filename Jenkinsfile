pipeline {
  agent {
    docker {
      image 'registry.cn-beijing.aliyuncs.com/liheng/maven-aliyun:3'
      args '-v /home/jenkins/.m2:/root/.m2:rw'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'Building'
        sh 'mkdir -p /root/.m2/repository/org'
        sh 'echo `id` && echo `ls -al /root/.m2/`'
        sh 'mvn clean package -Dmaven.test.skip=true'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying'
      }
    }
  }
}
