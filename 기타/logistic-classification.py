# [과제 5] 다중 입력 로지스틱 분류
# 작성일: 2020. 05. 19
# 작성자: 박찬형

import numpy as np

def loss_func(x, t):
    delta = 1e-7
    z = np.dot(x, W) + b
    y = sigmoid(z)
    
    # 발산 방지를 위해 매우 작은 수 delta 더해줌
    return -np.sum(t * np.log(y + delta) + (1 - t) * np.log((1 - y) + delta))

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def numerical_derivative(f, x):
    deltaX = 1e-4

    coefficient = np.zeros_like(x)
    it = np.nditer(x, flags=['multi_index'], op_flags=['readwrite'])

    while not it.finished:
        idx = it.multi_index
        tmp_val = x[idx]

        # x[idx] 가 loss_func의 W나 b중 올바른 자리에 들어갈 수 있는 이유는? 깊은 복사
        x[idx] = tmp_val + deltaX
        fx1 = f() # f(x + deltaX)

        x[idx] = tmp_val - deltaX
        fx2 = f() # f(x - deltaX)

        coefficient[idx] = (fx1 - fx2) / (2 * deltaX)

        x[idx] = tmp_val
        it.iternext()
    return coefficient

def predict(x):
    z = np.dot(x, W) + b
    y = sigmoid(z)
    if y >= 0.5:
        result = 1
    else:
        result = 0

    return result

f = lambda: loss_func(x_data, t_data)

x1_data = np.array([1, 3, 5, 7, 9, 11, 13, 15, 17, 19]).reshape(10, 1)
x2_data = np.array([4, 11, 6, 5, 7, 16, 8, 3, 7, 9]).reshape(10, 1)
x_data = np.concatenate((x1_data, x2_data), axis=1)
print(x_data.shape)
t_data = np.array([0, 0, 0, 0, 0, 1, 1, 1, 1, 1]).reshape(10, 1)

W = np.random.rand(2, 1)
print(W)
b = np.random.rand(1)

learning_rate = 1e-2

for step in range(10001):        
    W -= learning_rate * numerical_derivative(f, W)
    b -= learning_rate * numerical_derivative(f, b)
    if step % 400 == 0:
        print("Step: {:4d}".format(step), " error: {0:.20e}".format(loss_func(x_data, t_data)), " W:", W, " b:", b)

print("================================================")
print("학습 완료, W:", W, " b:", b)
print("================================================")
n1 = int(input("1번 변수 입력: "))
n2 = int(input("2번 변수 입력: "))
n = np.array([n1, n2])
print("================================================")
print("학습완료 후 x가", n, "일 때 예측값 y:", predict(n))