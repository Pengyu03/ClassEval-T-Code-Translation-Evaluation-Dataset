# ClassEval-T: Code Translation Evaluation Dataset

## Introduction

ClassEval-T is an open-source dataset specifically designed to evaluate the performance of large language models (LLMs) in code translation tasks. Designed by Du et al., ClassEval-T contains **94 real-world programming tasks**, covering scenarios like student registration systems, area calculators, Gomoku games, and more. This dataset features complex and substantial code, with an average of **66.7 lines of code** and **199.5 tokens per task**. To ensure comprehensive validation, each task includes **33.8 test cases**. The dataset is open for research purposes, enabling thorough evaluation of LLMs' code translation capabilities.

## Dataset

The ClassEval-T dataset includes code and corresponding test suites in three programming languages—Java, Python, and C++—organized in separate folders:

- **Java Dataset**: Contains Java implementations and test cases for all tasks.
- **Python Dataset**: Contains Python implementations and test cases for all tasks.
- **C++ Dataset**: Contains C++ implementations and test cases for all tasks.

Each language folder includes source code files and test cases, offering a rich multilingual resource for code translation tasks.

## Open-Source Code

To facilitate class-level code translation across different LLMs, this project includes invocation scripts for DeepSeek, NVIDIA, and Baidu Qianfan models. These scripts can be directly used to perform class-level code translations on ClassEval-T tasks. Each file contains the relevant prompt for the specific model, making it straightforward for researchers to use:

- **DeepSeek Invocation Script**: The `deepseek_invoke.py` file contains a script to call the DeepSeek model with a predefined prompt for code translation.
- **NVIDIA Invocation Script**: The `nvidia_invoke.py` file provides a script to call NVIDIA's LLM with the translation task prompt.
- **Baidu Qianfan Invocation Script**: The `baidu_qianfan_invoke.py` file contains a script to call the Baidu Qianfan model with a prompt suited for class-level code translation.

We design a most basic prompt to fit the above three strategies and mimic the easiest and most prevalent usage in practice, which can be formally defined as: 

“Translate the following ${𝑝𝑙𝑠𝑟𝑐} code to ${𝑝𝑙𝑑𝑠𝑡}:\n\n${𝑝𝑟𝑜𝑔𝑠𝑟𝑐 }”

where ${𝑝𝑙𝑠𝑟𝑐}, ${𝑝𝑙𝑑𝑠𝑡}, and ${𝑝𝑟𝑜𝑔𝑠𝑟𝑐} are placeholders for the source PL (e.g., Python, Java, and Python), target PL, and a program written in a certain source PL.

Using Python ——> C++ translation as an example, we show concrete prompt examples for three different strategies：
![681c927fe3f545b05c59e7932a64cf7](https://github.com/user-attachments/assets/af83c4e5-98a4-4b59-b4d1-2a96c6715f43)



## Environmental Requirements

1. **Solution Code**: Includes the code to be tested.
2. **Test Code**: Contains test cases for each task.
3. **Development Environment**: Recommended to use Visual Studio.

## Research Questions (RQs)

### RQ1 (Overall Correctness): How do recent LLMs perform on class-level code translation?

This research question investigates the overall correctness of class-level code translation across multiple languages, including Java, Python, and C++. We provide detailed test scripts for each language, which are located in the respective folders. Refer to the `README` file in each folder for specific test suite instructions and usage details.

### RQ2 (Translation Strategies): How do different translation strategies affect the performance of recent LLMs?

Since the Min Dependency Translation and Standalone Translation strategies generate code in blocks rather than as complete scripts, preprocessing is needed before running automated tests. Each programming language (Java, Python, and C++) has its own preprocessing file for code integration. You can use the language-specific `Min-Dependency-java|py|cpp.py` and `Standalone-java|py|cpp.py` scripts provided in each language folder. Note that, due to the complexity of merging code generated by LLMs, some manual adjustments may be required. When running the preprocessing scripts, be sure to update the file paths as shown below:

```python
# Set paths for the main folder and output folder
main_folder = "path_main"  # Replace with your main folder path
out_folder = "path_out"
```

### RQ4 (Failed Cases Analysis): What kinds of errors do LLMs make, and how frequently?

To address RQ4, we provide a manual evaluation tool that allows users to examine the accuracy of translated code. This tool assesses whether translation errors are present, helping researchers identify common error types in LLM code translation.

## Getting Started

1. **Clone the repository** and set up the environment.
2. **Data Preparation**: Ensure the ClassEval-T dataset is available and ready for LLM invocation.
3. **Running Experiments**:
    - For RQ1, refer to the `README` file in each language folder to follow detailed test script instructions.
    - For RQ2, preprocess translated code using the `Min-Dependency.py` and `Standalone.py` scripts after translation.
    - For RQ4, run `manual_eval_tool.py` for manual evaluation to assess the accuracy of translated code.

## Requirements

- Python 3.8+
