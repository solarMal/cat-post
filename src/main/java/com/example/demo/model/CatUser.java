package com.example.demo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CatUser {
   long id;
   String userName;
   String nickName;

   public CatUser(String userName, String nickName) {
      this.userName = userName;
      this.nickName = nickName;
   }
}
