# Modern Java Programming Examples

This repository contains examples demonstrating modern Java programming features introduced in Java 10-17.

## Repository Contents

### Original Examples
- **NumberOfWaysToCreateObject.java** - Different ways to create objects in Java (factory, reflection, serialization, cloning)
- **ShallowCopy.java** - Demonstrates shallow copying behavior
- **DeepCopy.java** - Demonstrates deep copying implementation

### Modern Java Features (Java 10-17)

#### 1. ModernJavaRecords.java
**Java Records (Java 14+)**
- Demonstrates the new Record syntax for immutable data classes
- Shows how records eliminate boilerplate code (constructors, getters, equals, hashCode, toString)
- Includes compact constructors for validation
- Shows records implementing interfaces
- **Benefits**: Immutable by default, concise syntax, perfect for DTOs

**Run:**
```bash
javac ModernJavaRecords.java
java ModernJavaRecords
```

#### 2. ModernTextBlocks.java
**Text Blocks (Java 15+)**
- Multi-line string literals without escape sequences
- Examples with JSON, SQL, HTML
- String formatting with text blocks
- Custom indentation control
- **Benefits**: Readable multi-line strings, no escape characters needed

**Run:**
```bash
javac ModernTextBlocks.java
java ModernTextBlocks
```

#### 3. ModernPatternMatching.java
**Pattern Matching for instanceof (Java 16+)**
- Eliminates explicit casting after instanceof checks
- Pattern variables with logical operators
- Null-safe pattern matching
- **Benefits**: Concise code, fewer casting errors, automatic scoping

**Run:**
```bash
javac ModernPatternMatching.java
java ModernPatternMatching
```

#### 4. ModernSwitchExpressions.java
**Switch Expressions (Java 14+)**
- Switch as an expression (returns values)
- Arrow syntax (->)
- Multiple case labels
- Yield keyword for complex blocks
- **Benefits**: No fall-through, exhaustiveness checking, more concise

**Run:**
```bash
javac ModernSwitchExpressions.java
java ModernSwitchExpressions
```

#### 5. ModernSealedClasses.java
**Sealed Classes (Java 17+)**
- Controlled inheritance with sealed, final, and non-sealed modifiers
- Restricts which classes can extend or implement
- Works with classes and interfaces
- Exhaustive pattern matching support
- **Benefits**: Controlled inheritance, better domain modeling, enhanced security

**Run:**
```bash
javac ModernSealedClasses.java
java ModernSealedClasses
```

#### 6. ModernVarAndFeatures.java
**var Keyword and Modern Features (Java 10+)**
- Local variable type inference with var
- Collection factory methods (List.of, Set.of, Map.of)
- Stream API enhancements (takeWhile, dropWhile)
- Optional improvements (ifPresentOrElse, or)
- String enhancements (strip, isBlank, lines, repeat)
- Teeing collector
- **Benefits**: Less boilerplate, cleaner code, improved APIs

**Run:**
```bash
javac ModernVarAndFeatures.java
java ModernVarAndFeatures
```

#### 7. ModernStreamAPI.java
**Stream API and Functional Programming**
- Filter, map, reduce operations
- Grouping and partitioning
- Statistics and aggregation
- Parallel streams
- Functional interfaces (Predicate, Function, Consumer, Supplier)
- **Benefits**: Declarative style, parallel processing, composable operations

**Run:**
```bash
javac ModernStreamAPI.java
java ModernStreamAPI
```

## Requirements

- Java 17 or higher
- No external dependencies required

## Installation

```bash
# Clone the repository
git clone https://github.com/harshal14ahire/Java.git
cd Java

# Compile any example
javac ModernJavaRecords.java

# Run the example
java ModernJavaRecords
```

## Compile and Run All Modern Examples

```bash
# Compile all modern Java files
javac Modern*.java

# Run each example
java ModernJavaRecords
java ModernTextBlocks
java ModernPatternMatching
java ModernSwitchExpressions
java ModernSealedClasses
java ModernVarAndFeatures
java ModernStreamAPI
```

## Key Features Demonstrated

### Java 10
- ✅ Local variable type inference (var)

### Java 11
- ✅ String methods (strip, isBlank, lines, repeat)
- ✅ var in lambda parameters

### Java 12
- ✅ Teeing collector

### Java 14
- ✅ Records (preview, finalized in Java 16)
- ✅ Switch expressions
- ✅ Pattern matching for instanceof (preview)

### Java 15
- ✅ Text blocks
- ✅ Pattern matching for instanceof (second preview)

### Java 16
- ✅ Records (finalized)
- ✅ Pattern matching for instanceof (finalized)

### Java 17
- ✅ Sealed classes

## Learning Path

1. **Start with var** - Learn type inference
2. **Text Blocks** - Master multi-line strings
3. **Records** - Understand immutable data classes
4. **Pattern Matching** - Simplify type checks
5. **Switch Expressions** - Modern control flow
6. **Sealed Classes** - Control inheritance
7. **Stream API** - Master functional programming

## Benefits of Modern Java

- 🚀 **More Productive** - Less boilerplate code
- 🛡️ **Type Safe** - Better compile-time checking
- 📖 **More Readable** - Cleaner, more expressive syntax
- 🔒 **More Secure** - Immutability by default with records
- ⚡ **Better Performance** - Optimized modern features

## Contributing

Feel free to add more modern Java examples or improve existing ones!

## License

This project is open source and available for educational purposes.

## Author

Harshal Ahire

---

**Note**: All examples are fully functional and demonstrate real-world use cases of modern Java features.
