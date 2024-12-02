In **Spring ORM**, the `load()` and `get()` methods are used to fetch data from the database. Here's the key difference:

### 1. **`load()`**
- **Does not fetch immediately:** It creates a "fake" object (called a proxy) at first, which represents the data.
- **Fetches data only when needed:** The real data is fetched from the database **only when you try to use it** (lazy loading).
- **Error if not found:** If the data is missing, it throws an `ObjectNotFoundException`.

### Example:
```java
// load() only gives a proxy object here, not the real data.
Employee emp = session.load(Employee.class, 1);

// Real data fetched only when accessing properties like emp.getName()
System.out.println(emp.getName());
```

### 2. **`get()`**
- **Fetches immediately:** It directly goes to the database and gets the real object.
- **Returns `null` if not found:** No error, just `null` if the data doesn’t exist.

### Example:
```java
// get() fetches data immediately
Employee emp = session.get(Employee.class, 1);

// You already have the data here, no extra fetching
System.out.println(emp.getName());
```

**In Short**:
- Use `load()` when you want to delay fetching and are sure the data exists.
- Use `get()` when you want to fetch immediately and handle cases where data might not exist.