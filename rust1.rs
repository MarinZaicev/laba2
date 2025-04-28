

use std::io;

fn flovers(water_count: Vec<i32>, volume: i32) -> i32 {
    let mut x = volume; // объем лейки
    let mut steps = 0; // кол-во шагов

    for (i, &water) in water_count.iter().enumerate() {
        if x < water{
            steps += 1;
        }else{
            if x - water >= 0 { // если воды для полива цветка достаточно
            x -= water;
            steps += 1;
        } else { // если воды для полива цветка недостаточно
            x = volume; // набираем лейку у реки
            steps += 2 * (i as i32 + 1) - 1; // прибавляем кол-во шагов от цветка до реки и обратно.
            x -= water;
        }
        }   
    }
    steps
}

fn bags(flower_count: i32) {
    if flower_count < 0 {
        println!("введено невозможное значение");
        std::process::exit(0); // завершаем выполнение программы
    }
}

fn main() {
    let mut input = String::new();
    println!("Введите количество цветов: ");
    io::stdin().read_line(&mut input).unwrap();
    let flovers_count: i32 = input.trim().parse().unwrap();
    bags(flovers_count);

    let mut vec_water_count = Vec::with_capacity(flovers_count as usize); // вектор для хранения потребностей цветов

    for i in 0..flovers_count {
        input.clear();
        println!("Введите кол-во воды, нужное для {} цветка: ", i + 1);
        io::stdin().read_line(&mut input).unwrap();
        let water_count: i32 = input.trim().parse().unwrap();
        bags(water_count);
        vec_water_count.push(water_count);
    }

    input.clear();
    println!("Введите объем лейки: ");
    io::stdin().read_line(&mut input).unwrap();
    let volume: i32 = input.trim().parse().unwrap();
    bags(volume);

    let steps = flovers(vec_water_count, volume);
    
    println!("{} шагов вы сделаете", steps);
}

