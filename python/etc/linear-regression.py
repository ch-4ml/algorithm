import numpy as np

def loss_func(x, t):
    y = np.dot(x, W) + b    
    return np.sum((y - t) ** 2) / len(x)

def numerical_derivative(f, x):
    deltaX = 1e-4

    coefficient = np.zeros_like(x)
    it = np.nditer(x, flags=['multi_index'], op_flags=['readwrite'])

    while not it.finished:
        idx = it.multi_index
        tmp_val = x[idx]

        # x[idx] 가 loss_func의 W나 b중 올바른 자리에 들어갈 수 있는 이유는?
        x[idx] = tmp_val + deltaX
        fx1 = f() # f(x + deltaX)

        x[idx] = tmp_val - deltaX
        fx2 = f() # f(x - deltaX)

        coefficient[idx] = (fx1 - fx2) / (2 * deltaX)

        x[idx] = tmp_val
        it.iternext()
    return coefficient

def predict(x):
    y = np.dot(x, W) + b
    return y

def f(): return loss_func(x_data, t_data)

x_data = np.array([1, 2, 3, 4, 5]).reshape(5, 1)
t_data = np.array([5, 8, 11, 14, 17]).reshape(5, 1)

W = np.random.rand(1, 1)
b = np.random.rand(1)
print("초기 오차 값:", loss_func(x_data, t_data), " 초기값 W:", W, " 초기값 b:", b)

learning_rate = 1e-2

for step in range(8001):
    W -= learning_rate * numerical_derivative(f, W)
    b -= learning_rate * numerical_derivative(f, b)
    if step % 400 == 0:
        print("Step: {:4d}".format(step), " error: {0:.20e}".format(loss_func(x_data, t_data)), " W:", W, " b:", b)

print("================================================")
print("학습 완료, W:", W, " b:", b)
print("================================================")
n = int(input("아무 숫자나 입력하면 예측값을 출력합니다: "))
print("================================================")
print("학습완료 후 x가", n, "일 때 예측값 y:", predict(n))