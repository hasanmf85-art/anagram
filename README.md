# 🔤 Anagram Finder (Kotlin)

A clean and efficient Kotlin application that reads a word list from a file and finds all groups of words that are anagrams of each other.

This project demonstrates:

- Algorithmic thinking  
- Kotlin collection handling  
- Clean project structure with Gradle  
- Practical problem-solving approach  

---

## 🚀 Problem Statement

Given a file (`eventyr.txt`) containing one word per line, the task is to:

- Identify words that have one or more anagrams in the same file  
- Group those words together  
- Print each group on a single line  
- Ignore words without anagrams  

---

## 💡 Solution Approach

The solution is based on the idea that:

> Two words are anagrams if they contain the same letters in a different order.

### Key idea:
Each word is transformed into a normalized signature:
akte → aekt
teak → aekt
kate → aekt

text

Words with the same signature are grouped together.

---

## ⚙️ Implementation Strategy

The program:

- Reads all words from file  
- Trims and filters empty lines  
- Creates a sorted character signature for each word  
- Groups words using `groupBy`  
- Filters out groups with only one word  
- Prints each anagram group  



## ▶️ How to Run

```bash
# Clone the repository
git clone https://github.com/hasanmf85-art/anagram
cd anagram

# Run with Gradle (Linux / macOS)
./gradlew run

# On Windows, use:
gradlew.bat run


gradlew.bat run
```
---

## 📊 Example Output

-  akte teak kate
-  alt tal
-  andre rande denar ander

Each line represents a group of words that are anagrams.

---
## 🧠 Core Logic

```bash
kotlin
val anagramGroups = words.groupBy { word ->
    word.toCharArray().sorted().joinToString("")
}

val validGroups = anagramGroups.values
    .filter { it.size > 1 }

validGroups.forEach {
    println(it.joinToString(" "))
}
```
----

## 🛠️ Built With
Kotlin

Gradle (Kotlin DSL)