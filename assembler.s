.section .data
prompt1: .asciz "сколько чисел вы планируете вводить?\n"
prompt2: .asciz "вводите числа \n"
error_msg: .asciz "вводите только положительное число\n"
input_fmt: .asciz "%d"
output_fmt: .asciz "%d\n"

.section .bss
.lcomm number, 4
.lcomm numberCount, 4
.lcomm sum, 4
.lcomm newN, 4
.lcomm position, 4
.lcomm positionCount, 4

.section .text
.globl main

pozition:
    pushq %rbp
    movq %rsp, %rbp
    
    movl $0, positionCount(%rip)
    movl $-1, position(%rip)
    movl %edi, newN(%rip)
    
pozition_loop:
    cmpl $0, newN(%rip)
    jle pozition_check
    
    incl position(%rip)
    
    movl newN(%rip), %eax
    movl $10, %ecx
    cltd
    idivl %ecx
    movl %edx, %ebx       # number = newN % 10
    movl %eax, newN(%rip) # newN /= 10
    
    movl position(%rip), %eax
    andl $1, %eax
    jz pozition_loop
    
    movl %ebx, %eax
    andl $1, %eax
    jz pozition_loop
    
    incl positionCount(%rip)
    jmp pozition_loop

pozition_check:
    movl position(%rip), %eax
    cmpl $0, %eax
    jle pozition_return_zero
    
    movl position(%rip), %eax
    incl %eax
    shrl $1, %eax         # (position + 1) / 2
    
    cmpl %eax, positionCount(%rip)
    jne pozition_return_zero
    
    movl %edi, %eax
    jmp pozition_end

pozition_return_zero:
    movl $0, %eax

pozition_end:
    popq %rbp
    ret

bags:
    pushq %rbp
    movq %rsp, %rbp
    
    cmpl $0, %edi
    jge bags_end
    
    movq $error_msg, %rdi
    call printf
    
    movq $0, %rdi
    call exit

bags_end:
    popq %rbp
    ret

main:
    pushq %rbp
    movq %rsp, %rbp
    
    # setlocale не реализован для упрощения
    
    movq $prompt1, %rdi
    call printf
    
    movq $numberCount, %rsi
    movq $input_fmt, %rdi
    movq $0, %rax
    call scanf
    
    movl numberCount(%rip), %edi
    call bags
    
    movq $prompt2, %rdi
    call printf
    
    movl $0, sum(%rip)
    
main_loop:
    cmpl $0, numberCount(%rip)
    jle main_end
    
    movq $number, %rsi
    movq $input_fmt, %rdi
    movq $0, %rax
    call scanf
    
    movl number(%rip), %edi
    call bags
    
    movl number(%rip), %edi
    call pozition
    
    addl %eax, sum(%rip)
    
    decl numberCount(%rip)
    jmp main_loop

main_end:
    movl sum(%rip), %esi
    movq $output_fmt, %rdi
    movq $0, %rax
    call printf
    
    movq $0, %rax
    popq %rbp
    ret
