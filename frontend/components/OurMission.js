import React from 'react';

const OurMission = () => {
    return (
        <div className='w-full mb-[106px]'>
            <div className='flex h-[500px] relative'>
                <div className='flex relative'>
                    <img className='h-[450px] w-[600px]' src="/main/imgModelMission.png" alt="modelMission"/>
                    <img className='absolute right-0 h-full' src="/main/bgShadowMission.svg" alt=""/>
                </div>
                <div className='bg-black w-full relative'>
                    <div className='ourMissionBlock'>
                        <h2 className='mb-[40px] font-normal not-italic text-[42px] leading-[25px] text-white'>Our Mission</h2>
                        <p className='w-[300px] not-italic font-normal text-[14px] leading-[28px] text-[#DEDEDE]'>We have invested 6 year of our lifes to invent a new technology of production a 3D dials with quality of wristwatch industry.
                            All what we need to turn on our imagination on maximum.

                            We love Out-of-the-box designs and believe there are many people who thinks the same.</p>
                    </div>
                </div>
                <div className='figure absolute right-[-150px]'></div>
                <div className='figure absolute bottom-[-50px] left-[300px]'></div>
            </div>
        </div>
    );
};

export default OurMission;