# **프로젝트, 멤버, 작업 관리 API**

프로젝트, 멤버, 작업을 관리할 수 있는 백엔드 API입니다. 프로젝트 생성, 수정, 조회 및 멤버와 작업의 CRUD 기능을 제공합니다.

---

## **목차**
1. **[📁 Project 기능](#1-project-기능)**
   - **Project 생성**
   - **Project 전체 조회**
   - **Project 이름 수정 기능**

2. **[👥 Member 기능](#2-member-기능)**
   - **Member 생성/추가 기능**
   - **Member들 불러오기**

3. **[📃 Task 기능](#3-task-기능)**
   - **Task 생성/추가 기능**
   - **Task 모두 불러오기**
   - **Task 이름 수정 기능**
   - **Task 삭제 기능**

---

## **1. 📁 Project 기능**

### **Project 생성**
- **설명**: 프로젝트 생성. 프론트엔드에서 `name`만 받고, `userId`와 `projectId`는 자동 생성됩니다.

| **메서드** | **요청 URL**    |
|------------|-----------------|
| POST       | `/projects`     |

#### **Request Elements**
| **파라미터**   | **타입** | **필수 여부** | **파라미터 이름** |
|----------------|----------|---------------|-------------------|
| `@RequestBody` | String   | 필수          | name              |

---

### **Project 전체 조회**
| **메서드** | **요청 URL**    |
|------------|-----------------|
| GET        | `/projects`     |

#### **응답 예시**
```json
[
    {
        "id": 1,
        "name": "프로젝트 이름",
        "userId": "고정된 UUID"
    },
    {
        "id": 2,
        "name": "다른 프로젝트 이름",
        "userId": "고정된 UUID"
    }
]
```

---

### **Project 이름 수정 기능**
| **메서드** | **요청 URL**               |
|------------|---------------------------|
| PATCH      | `/projects/{projectId}`   |

#### **Request Elements**
| **파라미터**    | **타입** | **필수 여부** | **파라미터 이름** |
|-----------------|----------|---------------|-------------------|
| `PathVariable`  | Long     | 필수          | projectId         |
| `@RequestBody`  | String   | 필수          | name              |

---

## **2. 👥 Member 기능**

### **Member 생성/추가 기능**
| **메서드** | **요청 URL**                     |
|------------|---------------------------------|
| POST       | `/projects/{projectId}/members` |

#### **Request Elements**
| **파라미터**   | **타입** | **필수 여부** | **파라미터 이름** |
|----------------|----------|---------------|-------------------|
| `PathVariable` | Long     | 필수          | projectId         |
| `@RequestParam`| String   | 필수          | name              |

---

### **Member들 불러오기**
| **메서드** | **요청 URL**                     |
|------------|---------------------------------|
| GET        | `/projects/{projectId}/members` |

#### **응답 예시**
```json
[
    {
        "id": 5,
        "name": "팀원1"
    },
    {
        "id": 6,
        "name": "팀원2"
    }
]
```

---

## **3. 📃 Task 기능**

### **Task 생성/추가 기능**
| **메서드** | **요청 URL**              |
|------------|---------------------------|
| POST       | `/tasks/{projectId}`      |

#### **Request Elements**
| **파라미터**   | **타입** | **필수 여부** | **파라미터 이름** |
|----------------|----------|---------------|-------------------|
| `PathVariable` | Long     | 필수          | projectId         |
| `@RequestBody` | String   | 필수          | title             |

---

### **Task 모두 불러오기**
| **메서드** | **요청 URL**              |
|------------|---------------------------|
| GET        | `/tasks/{projectId}`      |

#### **응답 예시**
```json
[
    {
        "id": 1,
        "title": "이거부터해~",
        "projectId": 1
    },
    {
        "id": 2,
        "title": "다음에는 이거양~",
        "projectId": 1
    },
    {
        "id": 3,
        "title": "우오 이것도 해~",
        "projectId": 1
    }
]
```

---

### **Task 이름 수정 기능**
| **메서드** | **요청 URL**              |
|------------|---------------------------|
| PATCH      | `/tasks/{taskId}`         |

#### **Request Elements**
| **파라미터**    | **타입** | **필수 여부** | **파라미터 이름** |
|-----------------|----------|---------------|-------------------|
| `PathVariable`  | Long     | 필수          | taskId            |
| `@RequestBody`  | String   | 필수          | title             |

---

### **Task 삭제 기능**
| **메서드** | **요청 URL**              |
|------------|---------------------------|
| DELETE     | `/tasks/{taskId}`         |

#### **Request Elements**
| **파라미터**    | **타입** | **필수 여부** | **파라미터 이름** |
|-----------------|----------|---------------|-------------------|
| `PathVariable`  | Long     | 필수          | taskId            |

---
