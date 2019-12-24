* Route53 do not use key/value pairs.
* Designing the application which needs to locate the public ip address of EC2 instance then visit http://169.254.169.254/latest/meta-data/
* Encryption at rest for EC2 and EBS then configure encryption when creating the EBS volume.
* Application constantly receiving read request to improve the performance of that where the application is stored in S3 then configure cloudfront CDN.
* S3 do not offer read after write consistency for PUTS of objects.
* EC2 servers with Spread placement group. Spread Placement Groups are recommended for applications that have a small number of critical instances which need to be kept separate from each other. Launching instances in a Spread Placement Group reduces the risk of simultaneous failures that might occur when instances share the same underlying hardware. Spread Placement Groups provide access to distinct hardware, and are therefore suitable for mixing instance types or launching instances over time. 
* S3 do not provides eventual consistency for PUT and deletes.
* To retreive instance metadata or user data then http://169.254.169.254.
* create a static hosting website in a bucket called "acloudguru" in Sydney using S3. What would the new URL endpoint be 
http://acloudguru.s3-website-ap-southeast-2.amazonaws.com
* Amazon EC2 reduces the time required to obtain and boot new server instances to minutes, allowing you to quickly scale capacity, both up and down, 
  as your computing requirements change. Amazon EC2 changes the economics of computing by allowing you to pay only for capacity that you actually use.
* Amazon EC2 enables any developer to leverage Amazon’s own benefits of massive scale with no up-front investment or performance compromises.
* You can start your AMI on any number of On-Demand EC2 instances by using the RunInstances API call.
* If Amazon EC2 is able to fulfill your request, RunInstances will return success, and we will start launching your instances. You can check on the status of your instances using the DescribeInstances API call. 
You can also programmatically terminate any number of your instances using the TerminateInstances API call.
* you have the option to use Spot Instances to reduce your computing costs when you have flexibility in when your applications can run.
* By using Amazon EBS, data on the root device will persist independently from the lifetime of the instance. This enables you to stop and restart the instance at a subsequent time, 
  which is similar to shutting down your laptop and restarting it when you need it again.
* Alternatively, the local instance store only persists during the life of the instance. This is an inexpensive way to launch instances where data is not stored to the root device. 
* The RunInstances call that initiates execution of your application stack will return a set of DNS names, one for each system that is being booted. 
    This name can be used to access the system exactly as you would if it were in your own data center.
* When you need more instances, you simply call RunInstances, and Amazon EC2 will typically set up your new instances in a matter of minutes. 
* Traditional hosting services generally provide a pre-configured resource for a fixed amount of time and at a predetermined cost. Amazon EC2 differs fundamentally in the flexibility, control and significant cost savings it offers developers, 
  allowing them to treat Amazon EC2 as their own personal data center with the benefit of Amazon.com’s robust infrastructure.
  When computing requirements unexpectedly change (up or down), Amazon EC2 can instantly respond, meaning that developers have the ability to control how many resources are in use at any given point in time. 
  In contrast, traditional hosting services generally provide a fixed number of resources for a fixed amount of time,
  Secondly, many hosting services don’t provide full control over the compute resources being provided. Using Amazon EC2, developers can choose not only to initiate or shut down instances at any time, 
  they can completely customize the configuration of their instances to suit their needs – and change it at any time.
* Finally, with Amazon EC2 developers enjoy the benefit of paying only for their actual resource consumption – and at very low rates. 
* ST1 volumes are backed by hard disk drives (HDDs) and are ideal for frequently accessed, throughput intensive workloads with large datasets and large I/O sizes, 
such as MapReduce, Kafka, log processing, data warehouse, and ETL workloads. SC1 volumes are backed by hard disk drives (HDDs) and provides the lowest cost per GB of all EBS volume types. 
It is ideal for less frequently accessed workloads with large, cold datasets. 
* While you are able to attach multiple volumes to a single instance, attaching multiple instances to one volume is not supported at this time.
* In order to ensure consistent snapshots on volumes attached to an instance, we recommend cleanly detaching the volume, issuing the snapshot command, and then reattaching the volume.
* Amazon EFS is compatible with all Amazon EC2 instance types and is accessible from Linux-based AMIs. 
* Amazon EC2 instances within your VPC can access your file system directly, and Amazon EC2 Classic instances outside your VPC can mount a file system via ClassicLink. 
  On-premises servers can mount your file systems via an AWS Direct Connect connection to your VPC.
* The Classic Load Balancer that routes traffic based on either application or network level information, and the Application Load Balancer that routes traffic
  based on advanced application level information that includes the content of the request.
* The Classic Load Balancer is ideal for simple load balancing of traffic across multiple EC2 instances, while the Application Load Balancer is ideal for applications needing advanced routing capabilities, microservices, and container-based architectures.
* Fleet management refers to the functionality that automatically replaces unhealthy instances and maintains your fleet at the desired capacity. Amazon EC2 Auto Scaling fleet management ensures that your application is able to receive traffic and that the instances themselves are working properly. 
  When Auto Scaling detects a failed health check, it can replace the instance automatically.
* If you have an EC2 Auto Scaling group (ASG) with running instances and you choose to delete the ASG, the instances will be terminated and the ASG will be deleted.
*  there is an API called SetInstanceHealth that allows you to change an instance's state to UNHEALTHY, which will then result in a termination and replacement.
* you can temporarily suspend Amazon EC2 Auto Scaling health checks by using the SuspendProcesses API. You can use the ResumeProcesses API to resume automatic health checks.
* Amazon Elastic Container Registry (ECR) is a fully-managed Docker container registry that makes it easy for developers to store, manage, and deploy Docker container images
* Amazon ECR is a regional service and is designed to give you flexibility in how images are deployed. You have the ability to push/pull images to the same region where your Docker cluster runs for the best performance. 
  You can also access Amazon ECR anywhere that Docker runs such as desktops and on-premises environments.
*  You can now setup AWS PrivateLink endpoints to allow your instances pull images without traversing through the public internet.

* Does Amazon ECR work with AWS Elastic Beanstalk? Yes. AWS Elastic Beanstalk supports Amazon ECR for both single and multi-container Docker environments allowing you to easily deploy container images stored in Amazon ECR with AWS Elastic Beanstalk. 
  All you need to do is specify the Amazon ECR repository in your Dockerrun.aws.json configuration and attach the AmazonEC2ContainerRegistryReadOnly policy to your container instance role.
* Yes. Amazon ECR is compatible with the Open Container Initiative (OCI) image specification letting you push and pull OCI images. 
* Amazon ECR automatically encrypts images at rest using S3 server side encryption and transfers your container images over HTTPS. You can configure policies to manage permissions and control access to your images using AWS Identity and Access Management (IAM) users and roles without having to manage credentials directly on your EC2 instances.
* Amazon Elastic Container Service (ECS) is a highly scalable, high performance container management service that supports Docker containers and allows you to easily run applications on a managed cluster of Amazon EC2 instances. Amazon ECS eliminates the need for you to install, operate, and scale your own cluster management infrastructure. 
  With simple API calls, you can launch and stop container-enabled applications, query the complete state of your cluster, and access many familiar features like security groups, Elastic Load Balancing, EBS volumes and IAM roles 
* Amazon ECS makes it easy to use containers as a building block for your applications by eliminating the need for you to install, operate, and scale your own cluster management infrastructure. 
* How is Amazon ECS different from AWS Elastic Beanstalk? AWS Elastic Beanstalk is an application management platform that helps customers easily deploy and scale web applications and services. It keeps the provisioning of building blocks (e.g., EC2, RDS, Elastic Load Balancing, Auto Scaling, CloudWatch), deployment of applications, and health monitoring abstracted from the user so they can just focus on writing code. 
  You simply specify which container images are to be deployed, the CPU and memory requirements, the port mappings, and the container links. 
* Elastic Beanstalk will automatically handle all the details such as provisioning an Amazon ECS cluster, balancing load, auto-scaling, monitoring, and placing your containers across your cluster. Elastic Beanstalk is ideal if you want to leverage the benefits of containers but just want the simplicity of deploying applications from development to production by uploading a container image. 
* ou can use Amazon ECS Run task to run one or more tasks once. Run task starts the task on an instance that meets the task’s requirements including CPU, memory and ports.
* Amazon ECR is integrated with Amazon ECS allowing you to easily store, run, and manage container images for applications running on Amazon ECS. All you need to do is specify the Amazon ECR repository in your Task Definition and attach the AmazonEC2ContainerServiceforEC2Role to your instances. 
  Then Amazon ECS will retrieve the appropriate images for your applications.
* How does AWS Fargate work with Amazon ECS? With Fargate, the concept of server provisioning, cluster management, and orchestration completely goes away. Amazon ECS uses containers provisioned by Fargate to automatically scale, load balance, and manage scheduling of your containers for availability, 
  providing an easier way to build and operate containerized applications.


* AWS EC2 :
1. web service that provides resizable compute capacity in the cloud. It is designed to make web-scale computing easier for developers.
* It provides you with complete control of your computing resources and lets you run on Amazon’s proven computing environment. 
    Amazon EC2 reduces the time required to obtain and boot new server instances to minutes, allowing you to quickly scale capacity, 
    both up and down, as your computing requirements change. 
* Until now, small developers did not have the capital to acquire massive compute resources and 
    ensure they had the capacity they needed to handle unexpected spikes in load. Amazon EC2 enables any developer to leverage Amazon’s own benefits of massive scale with no up-front investment or performance compromises. Developers are now free to innovate knowing that no matter how successful their businesses become, 
    it will be inexpensive and simple to ensure they have the compute capacity they need to meet their business requirements.
* The “Elastic” nature of the service allows developers to instantly scale to meet spikes in traffic or demand. When computing requirements unexpectedly change (up or down), Amazon EC2 can instantly respond, meaning that developers have the ability to control how many resources are in use at any given point in time. 
    In contrast, traditional hosting services generally provide a fixed number of resources for a fixed amount of time, meaning that users have a limited ability to easily respond when their usage is rapidly changing, unpredictable, or is known to experience large peaks at various intervals.
* RunInstances API call from EC2.DescribeInstances API call. TerminateInstances API call. StopInstances API call (but preserve the data on the boot partition) and StartInstances API
* When you launch your Amazon EC2 instances you have the ability to store your root device data on Amazon EBS or the local instance store. By using Amazon EBS, data on the root device will persist independently from the lifetime of the instance. 
    This enablesAmazon CloudWatch stores metrics for terminated Amazon EC2 instances or deleted Elastic Load Balancers for 2 weeks. you to stop and restart the instance at a subsequent time, 
    which is similar to shutting down your laptop and restarting it when you need it again. Alternatively, the local instance store only persists during the life of the instance. This is an inexpensive way to launch instances where data is not stored to the root device. 
* An Amazon Machine Image (AMI) is simply a packaged-up environment that includes all the necessary bits to set up and boot your instance. Your AMIs are your unit of deployment. 
* Retrieve metrics data for any Amazon EC2 instance up to 2 weeks from the time you started to monitor it
* If you want to archive metrics beyond 2 weeks you can do so by calling mon-get-stats command from the command line and storing the results in Amazon S3 or Amazon SimpleDB.
* Amazon CloudWatch stores metrics for terminated Amazon EC2 instances or deleted Elastic Load Balancers for 2 weeks.
* EC2 is a fully managed service designed to launch or terminate Amazon EC2 instances automatically to help ensure you have the correct number of Amazon EC2 instances available to handle the load for your application. 
    EC2 Auto Scaling helps you maintain application availability through fleet management for EC2 instances, which detects and replaces unhealthy instances, and by scaling your Amazon EC2 capacity up or down automatically according to conditions you define. 
    You can use EC2 Auto Scaling to automatically increase the number of Amazon EC2 instances during demand spikes to maintain performance and decrease capacity during lulls to reduce costs.
* You can hibernate an instance to get your instance and applications up and running quickly. In the case of hibernate, your instance gets hibernated and the RAM data persisted.
  In the case of Stop, your instance gets shutdown and RAM is cleared.
* You can resume by calling the StartInstances API as you would for a regular stopped instance. 
   You can also do this through the console by selecting your instance, then clicking Actions > Instance State > Start.
* RAM data is always encrypted when it is moved to the EBS root volume. Encryption on the EBS root volume is enforced at instance launch time. 
    This is to ensure protection for any sensitive content that is in memory at the time of hibernation.
* On-Demand Capacity Reservation is an EC2 offering that lets you create and manage reserved capacity on Amazon EC2. You can create a Capacity Reservation by choosing an Availability Zone and quantity (number of instances) along with other instance specifications such as instance type and tenancy. 
    Once created, the EC2 capacity is held for you regardless of whether you run the instances or not.
* A Reserved Instance (RI) is an EC2 offering that provides you with a significant discount on EC2 usage when you commit to a one-year or three-year term.
* Spot Instances are spare EC2 capacity that can save you up 90% off of On-Demand prices that AWS can interrupt with a 2-minute notification. Spot uses the same underlying EC2 instances as On-Demand and Reserved Instances, and is best suited for fault-tolerant, flexible workloads. 
    Spot Instances provides an additional option for obtaining compute capacity and can be used along with On-Demand and Reserved Instances.
* We highly recommend using multiple Spot capacity pools to maximize the amount of Spot capacity available to you. 
    EC2 provides built-in automation to find the most cost-effective capacity across multiple Spot capacity pools using EC2 Auto Scaling.
    
AWS IAM:
* To start using IAM, you must subscribe to at least one of the AWS services that is integrated with IAM. 
    You then can create and manage users, groups, and permissions via IAM APIs, the AWS CLI, or the IAM console.
* Create and manage IAM users, Create and manage IAM groups, Manage users' security credentials, Create and manage policies to grant access to AWS services and resources.   
* An IAM role is an IAM entity that defines a set of permissions for making AWS service requests. IAM roles are not associated with a specific user or group. 
    Instead, trusted entities assume roles, such as IAM users, applications, or AWS services such as EC2.
* IAM roles allow you to delegate access with defined permissions to trusted entities without having to share long-term access keys. 
    You can use IAM roles to delegate access to IAM users managed within your account, to IAM users under a different AWS account, or to an AWS service such as EC2.    
* You assume an IAM role by calling the AWS Security Token Service (STS) AssumeRole APIs (in other words, AssumeRole, AssumeRoleWithWebIdentity, and AssumeRoleWithSAML). 
    These APIs return a set of temporary security credentials that applications can then use to sign requests to AWS service APIs.    
* An IAM user has permanent long-term credentials and is used to directly interact with AWS services. An IAM role does not have any credentials and cannot make direct requests to AWS services. 
    IAM roles are meant to be assumed by authorized entities, such as IAM users, applications, or an AWS service such as EC2.   
* An IAM role is an AWS Identity and Access Management (IAM) entity with permissions to make AWS service requests. IAM roles cannot make direct requests to AWS services; they are meant to be assumed by authorized entities, such as IAM users, applications, or AWS services such as EC2. 
    Use IAM roles to delegate access within or between AWS accounts.    
* No. You can only associate one IAM role with an EC2 instance at this time. This limit of one role per instance cannot be increased.
* Access control policies are attached to users, groups, and roles to assign permissions to AWS resources. By default, IAM users, groups, and roles have no permissions; users with sufficient permissions must use a policy to grant the desired permissions.
* To set permissions, you can create and attach policies using the AWS Management Console, the IAM API, or the AWS CLI. Users who have been granted the necessary permissions can create policies and assign them to IAM users, groups, and roles.
* Managed policies are IAM resources that express permissions using the IAM policy language. You can create, edit, and manage separately from the IAM users, groups, and roles to which they are attached. After you attach a managed policy to multiple IAM users, groups, or roles, you can update that policy in one place and the permissions automatically extend to all attached entities. 
    Managed policies are managed either by you (these are called customer managed policies) or by AWS (these are called AWS managed policies).
* You can use the visual editor or the JSON editor in the IAM console. The visual editor is a point-and-click editor that guides you through the process of granting permissions in a policy without requiring you to write the policy in JSON. 
    You can create policies in JSON by using the CLI and SDK.    
* AWS provides a set of commonly used permissions that you can attach to IAM users, groups, and roles in your account. These are called AWS managed policies.
* Using IAM roles, IAM users and federated users can access resources in another AWS account via the AWS Management Console, the AWS CLI, or the APIs.  
* The IAM policy simulator is a tool to help you understand, test, and validate the effects of your access control policies. 
* Temporary security credentials consist of the AWS access key ID, secret access key, and security token. Temporary security credentials are valid for a specified duration and for a specific set of permissions. 
* You can call the GetFederationToken, AssumeRole, AssumeRoleWithSAML, or AssumeRoleWithWebIdentity STS APIs to request temporary security credentials.
* IAM users can request temporary security credentials for their own use by calling the AWS STS GetSessionToken API. 
    The default expiration for these temporary credentials is 12 hours; the minimum is 15 minutes, and the maximum is 36 hours.
    You can also use temporary credentials with Multi-Factor Authentication (MFA)-Protected API Access.
* If you're making direct HTTPS API requests to AWS, you can sign those requests with the temporary security credentials that you get from AWS Security Token Service (AWS STS). To do this, do the following:
    Use the access key ID and secret access key that are provided with the temporary security credentials the same way you would use long-term credentials to sign a request
    Use the session token that is provided with the temporary security credentials. Include the session token in the "x-amz-security-token" header. See the following example request.
        For Amazon S3, via the "x-amz- security-token" HTTP header.
        For other AWS services, via the SecurityToken parameter.    

AWS EBS:
*   AWS Elastic Beanstalk makes it even easier for developers to quickly deploy and manage applications in the AWS Cloud. Developers simply upload their application, 
    and Elastic Beanstalk automatically handles the deployment details of capacity provisioning, load balancing, auto-scaling, and application health monitoring.
*   Those who want to deploy and manage their applications within minutes in the AWS Cloud. 
*   AWS Elastic Beanstalk automates the details of capacity provisioning, load balancing, auto scaling, and application deployment, creating an environment that runs a version of your application. 
    You can simply upload your deployable code (e.g., WAR file), and AWS Elastic Beanstalk does the rest.       
*   Once your application is running, Elastic Beanstalk automates management tasks–such as monitoring, application version deployment, a basic health check–and facilitates log file access. 
    By using Elastic Beanstalk, developers can focus on developing their application and are freed from deployment-oriented tasks, such as provisioning servers, setting up load balancing, or managing scaling.   
*   Most existing application containers or platform-as-a-service solutions, while reducing the amount of programming required, significantly diminish developers’ flexibility and control. 
    Developers are forced to live with all the decisions predetermined by the vendor–with little to no opportunity to take back control over various parts of their application’s infrastructure. 
    However, with AWS Elastic Beanstalk, developers retain full control over the AWS resources powering their application. If developers decide they want to manage some (or all) of the elements of their infrastructure, they can do so seamlessly by using Elastic Beanstalk’s management capabilities.      
*   WS Elastic Beanstalk stores your application files and, optionally, server log files in Amazon S3. If you are using the AWS Management Console, the AWS Toolkit for Visual Studio, or AWS Toolkit for Eclipse, an Amazon S3 bucket will be created in your account for you and the files you upload will be automatically copied from your local client to Amazon S3. 
    Optionally, you may configure Elastic Beanstalk to copy your server log files every hour to Amazon S3. You do this by editing the environment configuration settings.
*   Elastic Beanstalk can automatically provision an Amazon RDS DB instance. The information about connectivity to the DB instance is exposed to your application by environment variables. 
    To learn more about how to configure RDS DB instances for your environment.

AWS Fargate:

*   AWS Fargate is a compute engine for deploying and managing containers, which frees you from having to manage any of the underlying infrastructure. 
    With AWS Fargate, you no longer have to provision, configure, and scale clusters of virtual machines to run containers.    
*   AWS Fargate supports all of the common container use cases, for example microservices architecture applications, batch processing, machine learning applications, 
    and migrating on premise applications to the cloud.    

AWS Lambda :

*   AWS Lambda lets you run code without provisioning or managing servers. You pay only for the compute time you consume - there is no charge when your code is not running. 
    With Lambda, you can run code for virtually any type of application or backend service - all with zero administration. 
   Just upload your code and Lambda takes care of everything required to run and scale your code with high availability. 
   You can set up your code to automatically trigger from other AWS services or call it directly from any web or mobile app. 
*   Serverless computing allows you to build and run applications and services without thinking about servers. With serverless computing, 
    your application still runs on servers, but all the server management is done by AWS. At the core of serverless computing is AWS Lambda, which lets you run your code without provisioning or managing servers.   
*    With Amazon EC2 you are responsible for provisioning capacity, monitoring fleet health and performance, and designing for fault tolerance and scalability whereas
    AWS Lambda makes it easy to execute code in response to events, such as changes to Amazon S3 buckets, updates to an Amazon DynamoDB table, or custom events generated by your applications or devices. 
    With Lambda you do not have to provision your own instances; Lambda performs all the operational and administrative activities on your behalf, including capacity provisioning, monitoring fleet health, 
    applying security patches to the underlying compute resources, deploying your code, running a web service front end, and monitoring and logging your code. AWS Lambda provides easy scaling and high availability to your code without additional effort on your part.
*   AWS Lambda offers an easy way to accomplish many activities in the cloud. For example, you can use AWS Lambda to build mobile back-ends that retrieve and transform data from Amazon DynamoDB, 
    handlers that compress or transform objects as they are uploaded to Amazon S3, auditing and reporting of API call.
*   AWS Lambda stores code in Amazon S3 and encrypts it at rest. AWS Lambda performs additional integrity checks while your code is in use.
*   The code you run on AWS Lambda is uploaded as a “Lambda function”. Each function has associated configuration information, such as its name, description, entry point, and resource requirements. 
*   The code must be written in a “stateless” style i.e. it should assume there is no affinity to the underlying compute infrastructure. 
*   Each Lambda function receives 500MB of non-persistent disk space in its own /tmp directory.
*   Keeping functions stateless enables AWS Lambda to rapidly launch as many copies of the function as needed to scale to the rate of incoming events. While AWS Lambda’s programming model is stateless, 
    your code can access stateful data by calling other web services, such as Amazon S3 or Amazon DynamoDB.
*    Inbound network connections are blocked by AWS Lambda, and for outbound connections only TCP/IP and UDP/IP sockets are supported.
*   Creation:
    If you are using Node.js or Python, you can author the code for your function using code editor in the AWS Lambda console which lets you author and test your functions, 
    and view the results of function executions in a robust, IDE-like environment.
    You can also package the code (and any dependent libraries) as a ZIP and upload it using the AWS Lambda console from your local environment 
    or specify an Amazon S3 location where the ZIP file is located. Uploads must be no larger than 50MB (compressed).
*   You can package the code (and any dependent libraries) as a ZIP and upload it using the AWS CLI from your local environment, 
    or specify an Amazon S3 location where the ZIP file is located. Uploads must be no larger than 50MB (compressed).   
*   For sensitive information, such as database passwords, we recommend you use client-side encryption using AWS Key Management Service and store the resulting values as ciphertext in your environment variable. 
    You will need to include logic in your AWS Lambda function code to decrypt these values.     
*   AWS Lambda automatically monitors Lambda functions on your behalf, reporting real-time metrics through Amazon CloudWatch, including total requests, account-level and function-level concurrency usage, latency, error rates, 
    and throttled requests. You can view statistics for each of your Lambda functions via the Amazon CloudWatch console or through the AWS Lambda console. You can also call third-party monitoring APIs in your Lambda function.
*   You do not have to scale your Lambda functions – AWS Lambda scales them automatically on your behalf. Every time an event notification is received for your function, AWS Lambda quickly locates free capacity within its compute fleet and runs your code. 
    Since your code is stateless, AWS Lambda can start as many copies of your function as needed without lengthy deployment and configuration delays. There are no fundamental limits to scaling a function. AWS Lambda will dynamically allocate capacity to match the rate of incoming events.
*   AWS Lambda functions can be configured to run up to 15 minutes per execution. You can set the timeout to any value between 1 second and 15 minutes.
*   An event source is an AWS service or developer-created application that produces events that trigger an AWS Lambda function to run. 
    Some services publish these events to Lambda by invoking the cloud function directly (for example, Amazon S3). Lambda can also poll resources in other services that do not publish events to Lambda. 
    For example, Lambda can pull records from an Amazon Kinesis stream or an Amazon SQS queue and execute a Lambda function for each fetched message.       
*   From the AWS Lambda console, you can select a function and associate it with notifications from an Amazon S3 bucket. Alternatively, 
    you can use the Amazon S3 console and configure the bucket’s notifications to send to your AWS Lambda function. This same functionality is also available through the AWS SDK and CLI.     
*   You can trigger a Lambda function on DynamoDB table updates by subscribing your Lambda function to the DynamoDB Stream associated with the table. 
    You can associate a DynamoDB Stream with a Lambda function using the Amazon DynamoDB console, the AWS Lambda console or Lambda’s registerEventSource API.   
 *  The Amazon Kinesis and DynamoDB Streams records sent to your AWS Lambda function are strictly serialized, per shard. 
    This means that if you put two records in the same shard, Lambda guarantees that your Lambda function will be successfully invoked with the first record before it is invoked with the second record. 
    If the invocation for one record times out, is throttled, or encounters any other error, Lambda will retry until it succeeds (or the record reaches its 24-hour expiration) before moving on to the next record. 
    The ordering of records across different shards is not guaranteed, and processing of each shard happens in parallel.
*   From the AWS Lambda console, you can select a Lambda function and associate it with an Amazon SNS topic. 
*   From the Amazon SES Console, you can set up your receipt rule to have Amazon SES deliver your messages to an AWS Lambda function. 
*   First, configure the alarm to send Amazon SNS notifications. Then from the AWS Lambda console, select a Lambda function and associate it with that Amazon SNS topic.
*   AWS Lambda is designed to process events within milliseconds. Latency will be higher immediately after a Lambda function is created, updated, or if it has not been used recently.
*   You upload the code you want AWS Lambda to execute and then invoke it from your mobile app using the AWS Lambda SDK included in the AWS Mobile SDK. You can make both direct (synchronous) calls to retrieve 
    or check data in real time as well as asynchronous calls. You can also define a custom API using Amazon API Gateway and invoke your Lambda functions through any REST compatible client. 
*   You can invoke a Lambda function over HTTPS by defining a custom RESTful API using Amazon API Gateway. This gives you an endpoint for your function which can respond to REST calls like GET, PUT and POST.
*   Lambda-based applications (also referred to as serverless applications) are composed of functions triggered by events. A typical serverless application consists of one or more functions triggered by events 
    such as object uploads to Amazon S3, Amazon SNS notifications, or API actions. These functions can stand alone or leverage other resources such as DynamoDB tables or Amazon S3 buckets. 
    The most basic serverless application is simply a function.    
*   You can deploy and manage your serverless applications using the AWS Serverless Application Model (AWS SAM). AWS SAM is a specification that prescribes the rules for expressing serverless applications on AWS. 
    This specification aligns with the syntax used by AWS CloudFormation today and is supported natively within AWS CloudFormation as a set of resource types (referred to as "serverless resources"). 
    These resources make it easier for AWS customers to use CloudFormation to configure and deploy serverless applications, using existing CloudFormation APIs.    
*   You can automate your serverless application’s release process using AWS CodePipeline and AWS CodeDeploy. CodePipeline is a continuous delivery service that enables you to model, visualize 
    and automate the steps required to release your serverless application. CodeDeploy provides a deployment automation engine for your Lambda-based applications. CodeDeploy lets you orchestrate 
    deployments according to established best-practice methodologies such as canary and linear deployments,    
*   To get started, visit the AWS Lambda console and download one of our blueprints. The file you download will contain an AWS SAM file (which defines the AWS resources in your application), 
    and a .ZIP file (which includes your function’s code). You can then use AWS CloudFormation commands to package and deploy the serverless application that you just downloaded.  
*   You can use AWS Step Functions to coordinate a series of AWS Lambda functions in a specific order. You can invoke multiple Lambda functions sequentially, passing the output of one to the other, 
    and/or in parallel, and Step Functions will maintain state during executions for you.      
*   You can enable your Lambda function for tracing with AWS X-Ray by adding X-Ray permissions to your Lambda function’s execution role and changing your function’s “tracing mode” to “active. 
    ” When X-Ray is enabled for your Lambda function, AWS Lambda will emit tracing information to X-Ray regarding the Lambda service overhead incurred when invoking your function. 
    This will provide you with insights such as Lambda service overhead, function init time, and function execution time. In addition, you can include the X-Ray SDK in your Lambda deployment package to create your own trace segments, annotate your traces, 
    or view trace segments for downstream calls made from your Lambda function. X-Ray SDKs are currently available for Node.js and Java.
*   Lambda@Edge allows you to run code across AWS locations globally without provisioning or managing servers, responding to end users at the lowest network latency. You just 
    upload your Node.js code to AWS Lambda and configure your function to be triggered in response to Amazon CloudFront request  The code is then ready to execute across AWS locations globally when a request for content is received, 
    and scales with the volume of CloudFront requests globally.        
*   To use Lambda@Edge, you just upload your code to AWS Lambda and associate a function version to be triggered in response to Amazon CloudFront requests. Your code must satisfy the Lambda@Edge service limits. Lambda@Edge only supports 
    Node.js for global invocation by CloudFront events at this time. 
*   Lambda@Edge is optimized for latency sensitive use cases where your end viewers are distributed globally. All the information you need to make a decision should be available at the CloudFront edge, within the function and the request. 
    This means that use cases where you are looking to make decisions on how to serve content based on user characteristics can now be executed and served close to your users without having to be routed back to a centralized server.
*   The difference is that API Gateway and Lambda are regional services. Using Lambda@Edge and Amazon CloudFront allows you to execute logic across multiple AWS locations based on where your end viewers are located.           
*   AWS Lambda is designed to use replication and redundancy to provide high availability for both the service itself and for the Lambda functions it operates. There are no maintenance windows or scheduled downtimes for either.
*   You grant permissions to your Lambda function to access other resources using an IAM role. AWS Lambda assumes the role while executing your Lambda function, so you always retain full, secure control of exactly which AWS resources it can use. 
*   No. Lambda functions provide access only to a single VPC. If multiple subnets are specified, they must all be in the same VPC.
*   Lambda functions configured to access resources in a particular VPC will not have access to the internet as a default configuration. If you need access to external endpoints, you will need to create a NAT in your VPC to forward this traffic 
    and configure your security group to allow this outbound traffic.

AWS SAM :
*   Serverless applications eliminate the need to provision, deploy, or manage servers or other infrastructure. They come with built-in high availability and they scale continuously and automatically. 
    You can use one of the many fully managed AWS services to build and run serverless applications, including AWS Lambda for compute, Amazon API Gateway for APIs, and Amazon DynamoDB for databases.
*   Serverless applications are deployed as AWS CloudFormation stacks, which make it easy for you to manage an application as a single unit. Each resource is tagged with the application’s uniquely identifiable Amazon Resource Name (ARN), 
    which helps you locate the resources using the AWS Tag Editor console. You can also use existing AWS and third-party tools to manage each resource separately.        
    
AWS ELB:
* Elastic Load Balancing supports three types of load balancers. You can select the appropriate load balancer based on your application needs. 
  If you need to load balance HTTP requests, we recommend you to use Application Load Balancer. For network/transport protocols (layer4 – TCP, UDP) load balancing, 
  and for extreme performance/low latency applications we recommend using Network Load Balancer. If your application is built within the EC2 Classic network then you should use Classic Load Balancer.
* Elastic Load Balancing supports three types of load balancers. You can select the appropriate load balancer based on your application needs. 
    If you need to load balance HTTP requests, we recommend you to use Application Load Balancer. For network/transport protocols (layer4 – TCP, UDP) load balancing, 
    and for extreme performance/low latency applications we recommend using Network Load Balancer. If your application is built within the EC2 Classic network then you should use Classic Load Balancer.
*  Yes. To receive a history of Application Load Balancing API calls made on your account, use AWS CloudTrail.
*  Yes, you can terminate HTTPS connection on the Application Load Balancer. You must install an SSL certificate on your load balancer. The load balancer uses this certificate to terminate the connection 
    and then decrypt requests from clients before sending them to targets.
*  You can either use AWS Certificate Manager to provision an SSL/TLS certificate or you can obtain the certificate from other sources by creating the certificate request, 
    getting the certificate request signed by a CA, and then uploading the certificate either using AWS Certification Manager or the AWS Identity and Access Management (IAM) service. 
*   You can integrate your Application Load Balancer with AWS WAF, a web application firewall that helps protect web applications from attacks by allowing you to configure rules 
    based on IP addresses, HTTP headers, and custom URI strings. Using these rules, AWS WAF can block, allow, or monitor (count) web requests for your web application.     
*    Cross-zone load balancing is already enabled by default in Application Load Balancer.
*   HTTP(S) requests received by a load balancer are processed by the content-based routing rules. 
    If the request content matches the rule with an action to forward it to a target group with a Lambda function as a target then the corresponding Lambda function is invoked. 
    The content of the request (including headers and body) is passed on to the Lambda function in JSON format. The response from the Lambda function should be in JSON format. 
    The response from the Lambda function is transformed into an HTTP response and sent to the client. The load balancer invokes your Lambda function using the AWS Lambda Invoke API 
    and requires that you have provided invoke permissions for your Lambda function to Elastic Load Balancing service.       
*   Yes. Network Load Balancers support both TCP, UDP, and TCP+UDP (Layer 4) listeners, as well as TLS listeners.
*   The Classic Load Balancer supports Amazon EC2 instances with any operating system currently supported by the Amazon EC2 service.

AWS Security Best Practices :

*   Using the IAM Service:
    *   The IAM service is one component of the AWS secure global infrastructure that
        we discuss in this paper. With IAM, you can centrally manage users, security
        credentials such as passwords, access keys, and permissions policies that control
        which AWS services and resources users can access.
    *   As a best practice, we recommend that you
        create an IAM user even for yourself and that you do not use your AWS account
        credentials for everyday access to AWS.
*   Regions, Availability Zones, and Endpoints:
*   Sharing Security Responsibility for AWS Services:
    *Infrastructure Services: This category includes compute services, such
                              as Amazon EC2, and related services, such as Amazon Elastic Block Store
                              (Amazon EBS), Auto Scaling, and Amazon Virtual Private Cloud (Amazon
                              VPC). With these services, you can architect and build a cloud
                              infrastructure using technologies similar to and largely compatible with
                              on-premises solutions. You control the operating system, and you
                              configure and operate any identity management system that provides
                              access to the user layer of the virtualization stack.
    *Container Services: You are responsible
                        for setting up and managing network controls, such as firewall rules, and
                        for managing platform-level identity and access management separately
                        from IAM. Examples of container services include Amazon Relational
                        Database Services (Amazon RDS), Amazon Elastic Map Reduce (Amazon
                        EMR) and AWS Elastic Beanstalk.
    *Abstracted Services: This category includes high-level storage,
                         database, and messaging services, such as Amazon Simple Storage Service
                         (Amazon S3), Amazon Glacier, Amazon DynamoDB, Amazon Simple
                         Queuing Service (Amazon SQS), and Amazon Simple Email Service
                         (Amazon SES).
*   For Amazon EC2 Windows instances using the ec2config service, when a new
    instance from a standard AWS AMI is launched, the ec2config service sets a
    new random Administrator password for the instance and encrypts it using the
    corresponding Amazon EC2 key pair’s public key. The user can get the Windows
    instance password by using the AWS Management Console or command line
    tools, and by providing the corresponding Amazon EC2 private key to decrypt
    the password. This password, along with the default Administrative account for
    the Amazon EC2 instance, can be used to authenticate to the Windows instance.
    
*   Using the Trusted Advisor Tool:
    * Some AWS Premium Support plans include access to the Trusted Advisor tool,
      which offers a one-view snapshot of your service and helps identify common
      security misconfigurations, suggestions for improving system performance, and
      underutilized resources.
* Manage AWS Accounts, IAM Users,Groups, and Roles:
    *  you should identify or create a new AWS group for that access, and
      provision user access via group membership, as well as permissions and policies
      assigned at the group level.
    * As a best practice, users should rotate their access keys on a regular
      basis. 
    * Applications that run on an Amazon EC2 instance and that need
      access to AWS resources such as Amazon S3 buckets or an
      Amazon DynamoDB table must have security credentials in order
      to make programmatic requests to AWS. Developers might
      distribute their credentials to each instance and applications can
      then use those credentials to access resources, but distributing
      long-term credentials to each instance is challenging to manage
      and a potential security risk.
    * To manage access to resources, you might have multiple AWS
      accounts—for example, to isolate a development environment from
      a production environment. However, users from one account might
      need to access resources in the other account, such as promoting
      an update from the development environment to the production
      environment. Although users who work in both accounts could
      have a separate identity in each account, managing credentials for
      multiple accounts makes identity management difficult.(cross account access).
    * Users might already have identities outside of AWS, such as in your
        corporate directory. However, those users might need to work with
        AWS resources (or work with applications that access those
        resources). If so, these users also need AWS security credentials
        in order to make requests toAWS.   
* IAM roles and temporary security credentials address these use cases. An IAM
  role lets you define a set of permissions to access the resources that a user or
  service needs, but the permissions are not attached to a specific IAM user or
  group. Instead, IAM users, mobile and EC2-based applications, or AWS services
  (like Amazon EC2) can programmatically assume a role. Assuming the role
  returns temporary security credentials that the user or application can use to
  make for programmatic requests to AWS. These temporary security credentials
  have a configurable expiration and are automatically rotated. Using IAM roles
  and temporary security credentials means you don't always have to manage longterm credentials 
  and IAM users for each entity that requires access to a resource  
* Managing OS-level Access to Amazon EC2 Instances :
    * Encryption–server side
      Amazon S3 supports server-side encryption of user data. Server-side
      encryption is transparent to the end user. AWS generates a unique
      encryption key for each object, and then encrypts the object using AES-256.
      The encryption key is then encrypted itself using AES-256-with a master key
      that is stored in a secure location. The master key is rotated on a regular
      basis.     
    * Encryption–client side :
      With client-side encryption you create and manage your own encryption
      keys. Keys you create are not exported to AWS in clear text. Your
      applications encrypt data before submitting it to Amazon S3, and decrypt
      data after receiving it from Amazon S3. Data is stored in an encrypted form,
      with keys and algorithms only known to you. While you can use any
      encryption algorithm, and either symmetric or asymmetric keys to encrypt
      the data, the AWS-provided Java SDK offers Amazon S3 client-side
      encryption features. See References and Further Reading for more
      information.                                                                           
 Blue/Green Deployments on AWS :
* Blue/green deployment is a technique for releasing applications by shifting traffic
  between two identical environments running different versions of the application.
  Blue/green deployments can mitigate common risks associated with deploying
  software, such as downtime and rollback capability. 
* In a traditional approach to application deployment, you typically fix a failed
  deployment by redeploying an older, stable version of the application.
  Redeployment in traditional data centers is typically done on the same set of
  resources due to the cost and effort of provisioning additional resources.
  Although this approach works, it has many shortcomings. Rollback isn’t easy
  because it’s implemented by redeployment of an older version from scratch. This
  process takes time, making the application potentially unavailable for long
  periods. Even in situations where the application is only impaired, a rollback is
  required, which overwrites the faulty version. As a result, you have no
  opportunity to debug the faulty application in place.
  Applying the principles of agility, scalability, utility consumption, and
  automation capabilities of the AWS platform can shift the paradigm of
  application deployment. This enables a better deployment technique called
  blue/green deployment.
* Blue/green deployments provide near zero-downtime release and rollback
  capabilities. The fundamental idea behind blue/green deployment is to shift
  traffic between two identical environments that are running different versions of
  your application. The blue environment represents the current application
  version serving production traffic. In parallel, the green environment is staged
  running a different version of your application. After the green environment is
  ready and tested, production traffic is redirected from blue to green. 
  If any problems are identified, you can roll back by reverting traffic back to the blue
  environment.
Benefits of Blue/Green :
* Blue/green deployments provide a level of
  isolation between your blue and green application environments. It ensures
  spinning up a parallel green environment does not affect resources underpinning
  your blue environment. This isolation reduces your deployment risk.
* After you deploy the green environment, you have the opportunity to validate it.
  You might do that with test traffic before sending production traffic to the green
  environment, or by using a very small fraction of production traffic, to better
  reflect real user traffic. This is called canary analysis or canary testing. If you
  discover the green environment is not operating as expected, there is no impact
  on the blue environment. You can route traffic back to it, minimizing impaired
  operation or downtime, and limiting the blast radius of impact.
Techniques:
* Update DNS Routing with Amazon Route 53
* Swap the Auto Scaling Group Behind Elastic Load Balancer.
* Update Auto Scaling Group Launch Configurations.
* Swap the Environment of an Elastic Beanstalk Application.
* Clone a Stack in AWS OpsWorks and Update DNS
When Blue/Green Deployments Are Not Recommended :
* Are your schema changes too complex to decouple from the code changes? Is sharing of data stores not feasible? 
* Does your application need to be “deployment aware”?

Implementing Microservices on AWS:
* Microservices architectures are not a completely new approach to software
  engineering, but rather a combination of various successful and proven
  concepts such as:
  • Agile software development
  • Service-oriented architectures
  • API-first design
  • Continuous Integration/Continuous Delivery (CI/CD)
* Typical monolithic applications are built using different layers—a user
 interface (UI) layer, a business layer, and a persistence layer. A central idea
 of a microservices architecture is to split functionalities into cohesive
 “verticals”—not by technological layers, but by implementing a specific domain.   
* AWS has integrated building blocks that support the development of
  microservices. Two popular approaches are using AWS Lambda5 and
  Docker containers with AWS Fargate6
* Docker images used in Amazon ECS and Amazon EKS can be stored in
  Amazon Elastic Container Registry (Amazon ECR.)
  eliminates the need to operate and scale the infrastructure required to power
  your container registry.  
* AWS Private Link is a highly available, scalable technology that enables
    you to privately connect your VPC to supported AWS services, services
    hosted by other AWS accounts (VPC endpoint services), and supported
    AWS Marketplace partner services. You do not require an internet gateway,
    NAT device, public IP address, AWS Direct Connect connection, or VPN
    connection to communicate with the service. 
* Step Functions is a reliable way to coordinate components and step through
  the functions of your application. Step Functions provides a graphical
  console to arrange and visualize the components of your application as a
  series of steps. This makes it simple to build and run distributed services.
  Step Functions automatically triggers and tracks each step and retries when
  there are errors, so your application executes in order and as expected. Step
  Functions logs the state of each step so when something goes wrong, you
  can diagnose and debug problems quickly. You can change and add steps
  without even writing code to evolve your application and innovate faster.
* Step Functions is part of the AWS serverless platform and supports
  orchestration of Lambda functions as well as applications based on compute
  resources, such as Amazon EC2 and Amazon ECS, and additional services
  like Amazon SageMaker47 and AWS Glue4
* To build workflows, Step Functions uses the Amazon States Language.
  Workflows can contain sequential or parallel steps as well as branching
  steps.  
* A microservices architecture consists of many different distributed parts that
 have to be monitored. You can use Amazon CloudWatch50 to collect and track metrics, centralize
 and monitor log files, set alarms, and automatically react to changes in your
 AWS environment. CloudWatch can monitor AWS resources such as EC2
 instances, DynamoDB tables, and RDS DB instances, as well as custom
 metrics generated by your applications and services, and any log files your
 applications generate.   
* You can use Amazon CloudWatch50 to collect and track metrics, centralize
  and monitor log files, set alarms, and automatically react to changes in your
  AWS environment. CloudWatch can monitor AWS resources such as EC2
  instances, DynamoDB tables, and RDS DB instances, as well as custom
  metrics generated by your applications and services, and any log files your
  applications generate.
* You can use CloudWatch to gain system-wide visibility into resource
  utilization, application performance, and operational health. CloudWatch
  provides a reliable, scalable, and flexible monitoring solution that you can
  start using within minutes. You no longer need to set up, manage, and scale
  your own monitoring systems and infrastructure. In a microservices
  architecture, the capability of monitoring custom metrics using CloudWatch
  is an additional benefit because developers can decide which metrics should
  be collected for each service. 
* Another popular option–especially for Amazon EKS–is to use Prometheus
  Prometheus is an open-source monitoring and alerting toolkit that is often
  used in combination with Grafana 53to visualize the collected metrics.  
* Consistent logging is critical for troubleshooting and identifying issues.
  Microservices allow teams to ship many more releases than ever before and
  encourage engineering teams to run experiments on new features in
  production. 
* Distributed Tracing: The central idea behind AWS X-Ray57 is the use of correlation IDs, which
   are unique identifiers attached to all requests and messages related to a
   specific event chain. The trace ID is added to HTTP requests in specific
   tracing headers named X-Amzn-Trace-Id when the request hits the first
   X-Ray-integrated service (for example, Application Load Balancer or API
   Gateway) and included in the response. Via the X-Ray SDK, any
   microservice can read but can also add or update this header    
* Options for Log Analysis on AWS:
    Searching, analyzing, and visualizing log data is an important aspect of
    understanding distributed systems. Amazon CloudWatch Logs Insights is a
    great service to explore, analyze, and visualize your logs instantly. This
    allows you to troubleshoot operational problems. Another option for
    analyzing log files is to use Amazon ES together with Kibana.
    Amazon ES can be used for full-text search, structured search, analytics,
    and all three in combination. Kibana is an open source data visualization
    plugin for Amazon ES that seamlessly integrates with it.
* Cloud Trail is a useful tool for tracking changes in microservices
  because it enables all API calls made in the AWS Cloud to be logged and
  sent to either CloudWatch Logs in real time, or to Amazon S3 within several
  minutes.    
* The advantages of storing the audit trails in CloudWatch are that audit trail
  data is captured in real time, and it is easy to reroute information to Amazon
  ES for search and visualization. You can configure CloudTrail to log into
  both Amazon S3 and CloudWatch Logs.            

Practicing Continuous Integration and Continuous Delivery on AWS :
* AWS now offers these CI/CD capabilities as a set of developer services: 
  AWSCodeStar,
  AWS CodeCommit,
  AWS CodePipeline,
  AWS CodeBuild,
   and
  AWS CodeDeploy.
  
* use AWS CodeStar to rapidly orchestrate an end-to-end software release workflow using these services.
* AWS CodePipeline has the flexibility to integrate each service independently with your existing tools. These are highly available, easily
  integrated services that can be accessed.
* Continuous integration (CI) is a software development practice where
  developers regularly merge their code changes into a central repository, after
  which automated builds and tests are run. CI most often refers to the build or
  integration stage of the software release process and requires both an
  automation component (e.g., a CI or build service) and a cultural component
  (e.g., learning to integrate frequently). The key goals of CI are to find and
  address bugs more quickly, improve software quality, and reduce the time it
  takes to validate and release new software updates.
* The basic challenges of implementing CI include more frequent commits to the
  common codebase, maintaining a single source code repository, automating
  builds, and automating testing. Additional challenges include testing in similar
  environments to production, providing visibility of the process to the team, and
  allowing developers to easily obtain any version of the application.
* Continuous delivery (CD) is a software development practice where code
  changes are automatically built, tested, and prepared for production release. It 
  expands on continuous integration by deploying all code changes to a testing
  environment, a production environment, or both after the build stage has been
  completed. Continuous delivery can be fully automated with a workflow process
  or partially automated with manual steps at critical points. When continuous
  delivery is properly implemented, developers always have a deployment-ready
  build artifact that has passed through a standardized test process.
* One misconception about continuous delivery is that it means every change
  committed is applied to production immediately after passing automated tests.
  However, the point of continuous delivery is not to apply every change to
  production immediately, but to ensure that every change is ready to go to
  production.
* Before deploying a change to production, you can implement a decision process
  to ensure that the production deployment is authorized and audited. This
  decision can be made by a person and then executed by the tooling.
  Using continuous delivery the decision to go live becomes a business decision,
  not a technical one. The technical validation happens on every commit.
* Benefits of Continuous Delivery
    * Automate the Software Release Process
    * Improve Developer Productivity
    * Improve Code Quality
    * Deliver Updates Faster
* AWS recommends organizing three developer teams for implementing a CI/CD
  environment: an application team, an infrastructure team, and a tools team
  The application team creates the application. Application developers own the
  backlog, stories, and unit tests, and they develop features based on a specified
  application target. 
  The infrastructure team writes the code that both creates and configures the
  infrastructure needed to run the application. This team might use native AWS
  tools, such as AWS CloudFormation, or generic tools, such as Chef, Puppet, or
  Ansible. The infrastructure team is responsible for specifying what resources are
  needed, and it works closely with the application team.
  The tools team builds and manages the CI/CD pipeline. They are responsible for
  the infrastructure and tools that make up the pipeline. They are not part of the
  two-pizza team, however they create a tool that is used by the application and
  infrastructure teams in the organization.
* Building the Pipeline:
*                