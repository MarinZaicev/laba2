use std::io;

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

fn main() {
    println!("Сколько чисел вы планируете вводить?");
    
    let mut number_count = String::new();
    io::stdin()
        .read_line(&mut number_count)
        .expect("Ошибка чтения ввода");
    let number_count: i32 = number_count.trim().parse().expect("Введите число");
    
    println!("Вводите числа");
    let mut sum = 0;
    
    for _ in (1..=number_count).rev() {
        let mut number = String::new();
        io::stdin()
            .read_line(&mut number)
            .expect("Ошибка чтения ввода");
        let number: i32 = number.trim().parse().expect("Введите число");
        
        sum += pozition(number);
    }
    
    println!("{}", sum);
}
