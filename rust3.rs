use std::io;
use std::process;

fn pozition(n: i32) -> i32 {
    let mut position = -1;
    let mut position_count = 0;
    let mut new_n = n;
    
    while new_n > 0 {
        position += 1;
        let number = new_n % 10;
        new_n /= 10;
        if position % 2 != 0 && number % 2 != 0 {
            position_count += 1;
        }
    }
    
    if (position_count == (position + 1) / 2) && (position > 0) {
        n
    } else {
        0
    }
}

fn bags(try_number: i32) {
    if try_number < 0 {
        println!("вводите только положительное число");
        process::exit(0);
    }
}

fn main() {
    println!("сколько чисел вы планируете вводить?");
    
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Ошибка чтения");
    let number_count: i32 = input.trim().parse().expect("Введите число");
    bags(number_count);
    
    println!("вводите числа");
    let mut sum = 0;
    
    for _ in 0..number_count {
        let mut num_input = String::new();
        io::stdin().read_line(&mut num_input).expect("Ошибка чтения");
        let number: i32 = num_input.trim().parse().expect("Введите число");
        bags(number);
        sum += pozition(number);
    }
    
    println!("{}", sum);
}
