# Text File Processor Lambda

A **Java 17 AWS Lambda** function that automatically processes `.txt` files uploaded to an S3 bucket.  
The Lambda function counts lines, words, and characters, extracts a 100-character preview, and stores the results in a DynamoDB table.

---

## 📘 Project Overview

### Workflow Summary
1. **S3 Bucket** – Receives `.txt` file uploads and triggers the Lambda function.  
2. **Lambda Function** – Processes each file by:
   - Counting **lines**, **words**, and **characters**  
   - Extracting the **first 100 characters** as a preview  
   - Storing results in **DynamoDB**  
3. **DynamoDB Table** – Stores the file processing results and metadata.

---

## 🗂️ Project Structure
TextFileProcessor/
├── pom.xml # Maven configuration and dependencies
├── README.md # Project documentation
└── src/
└── main/
└── java/
└── com/
└── example/
└── TextFileProcessor.java # Main Lambda handler

- **TextFileProcessor.java** — Main Lambda handler implementation  
- **pom.xml** — Maven configuration and dependencies  

---

## ☁️ AWS Resources

1. **S3 Bucket**  
   - Name: `file-processing-bucket-task`  
   - Trigger: ObjectCreated event for `.txt` files  

2. **DynamoDB Table**  
   - Table Name: `FileProcessingResults`  
   - Partition Key: `fileName` (String)  
   - Attributes: `lineCount`, `wordCount`, `charCount`, `preview`, `processedDate`  

3. **IAM Role for Lambda**  
   Permissions required:
   - Read from **S3**  
   - Write to **DynamoDB**  
   - Basic Lambda execution permissions (**CloudWatch logs**)  

---

## 🛠️ Build Instructions

Ensure **Java 17** and **Maven** are installed.

In the project root, run:

```bash
mvn clean package
```
## 🛠️ Build Output

This will generate the JAR file in the `target/` directory:


---

## 🚀 Deploying to AWS Lambda

1. Go to **AWS Lambda Console → Create Function → Author from Scratch**
2. **Runtime:** Java 17  
3. **Upload the built JAR:** `TextFileProcessor-1.0.jar`
4. **Handler:** com.example.TextFileProcessor::handleRequest
5. Assign the **IAM role** created earlier.
6. Add an **S3 bucket trigger** for `.txt` file uploads.

---

## 🧪 Testing

1. Upload a `.txt` file (e.g., `sample.txt`) to your S3 bucket.
   <img width="635" height="521" alt="image" src="https://github.com/user-attachments/assets/e9dcd9cf-bca7-4bf4-bf09-8f887aedc9dd" />

2. Check **CloudWatch Logs** for successful execution.  
3. Verify that the **DynamoDB table** contains the new record with the file processing results.
   <img width="947" height="298" alt="image" src="https://github.com/user-attachments/assets/f2b15cd0-60fa-43eb-bf20-2444e5091b5f" />


---

## ⚡ Features

- Counts **lines**, **words**, and **characters** in any uploaded `.txt` file  
- Stores a **100-character preview** for quick reference  
- Automatically triggered by **S3 file uploads**  
- Results are **persisted in DynamoDB** for later analysis  

---

## 📝 Notes

- Ensure the **Lambda function** and **S3 bucket** are in the same region.  
- File previews longer than **100 characters** will be truncated.  
- The **DynamoDB table** must exist before uploading files for the Lambda to succeed.
 

