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
* It provides you with complete control of your computing resources and lets you run on Amazon’s proven computing environment. Amazon EC2 reduces the time required to obtain and boot new server instances to minutes, allowing you to quickly scale capacity, both up and down, as your computing requirements change. 
* Until now, small developers did not have the capital to acquire massive compute resources and ensure they had the capacity they needed to handle unexpected spikes in load. Amazon EC2 enables any developer to leverage Amazon’s own benefits of massive scale with no up-front investment or performance compromises. Developers are now free to innovate knowing that no matter how successful their businesses become, 
    it will be inexpensive and simple to ensure they have the compute capacity they need to meet their business requirements.
* The “Elastic” nature of the service allows developers to instantly scale to meet spikes in traffic or demand. When computing requirements unexpectedly change (up or down), Amazon EC2 can instantly respond, meaning that developers have the ability to control how many resources are in use at any given point in time. 
    In contrast, traditional hosting services generally provide a fixed number of resources for a fixed amount of time, meaning that users have a limited ability to easily respond when their usage is rapidly changing, unpredictable, or is known to experience large peaks at various intervals.
* RunInstances API call from EC2.DescribeInstances API call. TerminateInstances API call. StopInstances API call (but preserve the data on the boot partition) and StartInstances API
* When you launch your Amazon EC2 instances you have the ability to store your root device data on Amazon EBS or the local instance store. By using Amazon EBS, data on the root device will persist independently from the lifetime of the instance. This enables you to stop and restart the instance at a subsequent time, 
    which is similar to shutting down your laptop and restarting it when you need it again. Alternatively, the local instance store only persists during the life of the instance. This is an inexpensive way to launch instances where data is not stored to the root device. 
* An Amazon Machine Image (AMI) is simply a packaged-up environment that includes all the necessary bits to set up and boot your instance. Your AMIs are your unit of deployment. 
* retrieve metrics data for any Amazon EC2 instance up to 2 weeks from the time you started to monitor it
* If you want to archive metrics beyond 2 weeks you can do so by calling mon-get-stats command from the command line and storing the results in Amazon S3 or Amazon SimpleDB.
