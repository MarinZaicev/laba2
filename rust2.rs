use std::io;
use std::process;

fn zamena_zero(s: &str, k: i32) -> i32 {
    let mut max_one_count = 0;  // Максимальное значение единиц
    let mut zero_count = 0;     // Количество нулей в текущем окне
    let mut j = 0;              // Левая граница окна
    
    let chars: Vec<char> = s.chars().collect();
    
    for i in 0..chars.len() {
        if chars[i] == '0' {
            zero_count += 1;  // Увеличиваем счетчик нулей
        }
        
        while zero_count > k {
            if chars[j] == '0' {
                zero_count -= 1;  // Уменьшаем счетчик нулей
            }
            j += 1;
        }
        
        max_one_count = std::cmp::max(max_one_count, (i - j + 1) as i32);
    }
    
    max_one_count
}

fn check_binary(s: &str) {
    for c in s.chars() {
        if c != '0' && c != '1' {
            println!("Строка бинарная и должна состоять только из 0 и 1");
            process::exit(0);
        }
    }
}

fn main() {
    println!("Введите бинарную строку: ");
    let mut s = String::new();
    io::stdin().read_line(&mut s).expect("Ошибка ввода");
    let s = s.trim();
    
    check_binary(s);
    
    println!("Введите число K: ");
    let mut k_str = String::new();
    io::stdin().read_line(&mut k_str).expect("Ошибка ввода");
    let k: i32 = match k_str.trim().parse() {
        Ok(num) => num,
        Err(_) => {
            println!("Ошибка: введите целое число");
            process::exit(0);
        }
    };
    
    if k < 0 {
        println!("Данное число не может быть меньше 0");
        process::exit(0);
    }
    
    let result = zamena_zero(s, k);
    println!("Максимальная длина последовательности единиц: {}", result);
}
