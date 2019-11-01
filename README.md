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