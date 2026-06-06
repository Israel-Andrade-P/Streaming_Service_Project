package com.zeldev.streaming_service.model;

import com.zeldev.streaming_service.enumeration.AccountType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscribers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}

//The way Im building this is, theres a subscriber which is the main user who can add up to three profiles
//representing other users, these profiles can be KID, TEENAGER and ADULT ype, depending on the profile type
//determines what movies they have access to, the main user can subscribe to BASIC, STANDRD or a PREMIUM account,
//that also determines what movies they and the profiles have access to, profiles inherit the account type from
//the main user. The main user can login with email and password, and can share their email and password to the
//profile owners so they can have access to it too. The profiles dont have their own email or password, they gotta
//log in using the main user's credentials

//User logs in, spring creates session a
//get sub auth info:
//@GetMapping("/me")
//public String me(Authentication auth) {
//    return auth.getName();
//}
//List available profiles for that user:
//@GetMapping("/profiles")
//public List<ProfileDto> getProfiles(Authentication auth) {
//    String email = auth.getName();
//    Subscriber subscriber =
//            subscriberRepository.findByEmail(email)
//                    .orElseThrow();
//    return profileRepository.findBySubscriberId(
//            subscriber.getId()
//    );
//}
//Store and select a profile in session:
//@PostMapping("/profiles/{profileId}/select")
//public void selectProfile(
//        @PathVariable Long profileId,
//        HttpSession session) {
//    session.setAttribute(
//            "ACTIVE_PROFILE_ID",
//            profileId
//    );
//}
//Session now contains:
//JSESSIONID
//        Authentication
//ACTIVE_PROFILE_ID = 2
//From that, load profile and filter movies according to age and account type

























