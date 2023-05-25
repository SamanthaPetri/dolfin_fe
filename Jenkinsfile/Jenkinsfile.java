pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo "Compile the code and generate any necessary artifacts."
                echo "Can use code automation tool such as Maven. Maven is a tool primarily used for Java projects "
            }
        }
        stage('Tests') {
            steps {
                // Execute the Selenium script
                sh 'python selenium_script.py'
            }
            post {
                success {
                    emailext to: "sammypetri96@gmail.com",
                    subject: "Test status email",
                    body: "Testing was succesful!",
                    attachLog: true
                }
                failure {
                    emailext to: "sammypetri96@gmail.com",
                    subject: "Test status email",
                    body: "Testing was unsuccesful",
                    attachLog: true
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Integrate code analysis tool to analyse the code and ensure it meets industry standards"
                echo "Can use code analysis tool such as Coverity (used for C, C++, C#, Java and JavaScript)"
            }
        }
        stage('Security Scan') {
            steps {
                echo "Perform a security scan on code using a tool to identify any vulnerabilities"
                echo "Can use security tool such as AttackFlow (which maps data security risks)"
            }
            post {
                success {
                    emailext to: "sammypetri96@gmail.com",
                    subject: "Security scan status email",
                    body: "Security scan was succesful!",
                    attachLog: true
                }
                failure {
                    emailext to: "sammypetri96@gmail.com",
                    subject: "Security scan status email",
                    body: "Security scan was unsuccesful",
                    attachLog: true
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "Deploy the application to a staging server"
                echo "Can use a staging server such as an AWS EC2 (Elastic Compute) instance"
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo "Run integration tests on staging environment to ensure app functions as expected in production-like environment"
                echo "Can run integration tests in EC2 instance"
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploy the application to a production server"
                echo "Can deploy to an AWS EC2 instance"
            }
        }
    }
}