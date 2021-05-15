# 카프카 연습하기

## kafka 환경 구축

도커 돌리기
```
 $ git clone https://github.com/wurstmeister/kafka-docker.git
 $ cd kafka-docker
 $ ./bin/docker-compose -f docker-compose-single-broker.yml /bin/bash 
```

host 설정.(host 설정을 안했더니 kafka라는 host를 못찾는다는 에러가 났다..)
```
$ vim /etc/hosts

-- 추가 
127.0.0.1   kafka
```

